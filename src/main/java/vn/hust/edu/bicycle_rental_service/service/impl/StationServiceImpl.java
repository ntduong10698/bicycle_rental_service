package vn.hust.edu.bicycle_rental_service.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.hust.edu.bicycle_rental_service.type.StatusType;
import vn.hust.edu.bicycle_rental_service.dto.request.PostListStationReq;
import vn.hust.edu.bicycle_rental_service.dto.response.BicycleResp;
import vn.hust.edu.bicycle_rental_service.dto.response.PostListStationResp;
import vn.hust.edu.bicycle_rental_service.dto.response.StationResp;
import vn.hust.edu.bicycle_rental_service.entities.BicycleEntity;
import vn.hust.edu.bicycle_rental_service.entities.StationEntity;
import vn.hust.edu.bicycle_rental_service.repository.BicycleRepo;
import vn.hust.edu.bicycle_rental_service.repository.StationRepo;
import vn.hust.edu.bicycle_rental_service.service.StationService;
import vn.hust.edu.bicycle_rental_service.until.AppUntil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Log4j2
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepo stationRepo;

    private final BicycleRepo bicycleRepo;

    private final AppUntil appUntil;

    @Override
    public PostListStationResp postListStation(PostListStationReq req) {
        try {
            List<StationResp> listStation = new ArrayList<>();
            List<StationEntity> stationList = stationRepo.findByNameAndAddressAndStatus(req.getName(), req.getAddress(), StatusType.ACTIVE.name());
            if (!CollectionUtils.isEmpty(stationList)) {
                Map<Integer, List<BicycleEntity>> bicycleMap = new HashMap<>();
                bicycleRepo.findByStationIdIn(stationList
                        .stream().map(StationEntity::getId).collect(Collectors.toList()), StatusType.ACTIVE.name())
                        .parallelStream().forEach(b -> {
                    List<BicycleEntity> l = bicycleMap.get(b.getStationId());
                    if (CollectionUtils.isEmpty(l)) {
                        l = new ArrayList<>();
                    }
                    l.add(b);
                    bicycleMap.put(b.getStationId(), l);
                });

                Stream<StationResp> streamListStation = stationList.parallelStream().map(s -> {
                    StationResp stationResp = new ModelMapper().map(s, StationResp.class);
                    List<BicycleEntity> bicycleList = bicycleMap.get(s.getId());
                    stationResp.setSizeEmpty(s.getSize());
                    if (!CollectionUtils.isEmpty(bicycleList)) {
                        stationResp.setSizeEmpty(s.getSize() - bicycleList.size());
                        stationResp.setListBicycle(bicycleList.parallelStream().map(b -> {
                            BicycleResp bRs = appUntil.convertValue(b, BicycleResp.class);
                            bRs.setType(appUntil.getBicycleType(b.getTypeId()));
                            return bRs;
                        }).collect(Collectors.toList()));
                    }
                    return stationResp;
                });

                if(Objects.nonNull(req.getIsEmpty()) && req.getIsEmpty()) {
                    listStation = streamListStation.filter(s -> s.getSizeEmpty() > 0).collect(Collectors.toList());
                } else {
                    listStation = streamListStation.collect(Collectors.toList());
                }

            }
            return PostListStationResp.builder()
                    .listStation(listStation)
                    .build();
        } catch (Exception e) {
            log.error("==== Error StationServiceImpl postListStation with error: {}", e);
            throw e;
        }
    }

}
