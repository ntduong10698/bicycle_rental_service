package vn.hust.edu.bicycle_rental_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.hust.edu.bicycle_rental_service.dto.response.BicycleResp;
import vn.hust.edu.bicycle_rental_service.dto.response.GetListStationResp;
import vn.hust.edu.bicycle_rental_service.dto.response.StationResp;
import vn.hust.edu.bicycle_rental_service.entities.BicycleEntity;
import vn.hust.edu.bicycle_rental_service.entities.StationEntity;
import vn.hust.edu.bicycle_rental_service.repository.BicycleRepo;
import vn.hust.edu.bicycle_rental_service.repository.StationRepo;
import vn.hust.edu.bicycle_rental_service.service.StationService;
import vn.hust.edu.bicycle_rental_service.until.AppUntil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepo stationRepo;

    private final BicycleRepo bicycleRepo;

    private final AppUntil appUntil;

    @Override
    public GetListStationResp getListStation() {
        GetListStationResp rs = GetListStationResp.builder()
                .listStation(new ArrayList<>())
                .build();
        List<StationEntity> stationList = stationRepo.findAll();
        if (!CollectionUtils.isEmpty(stationList)) {
            Map<Integer, List<BicycleEntity>> bicycleMap = new HashMap<>();
            bicycleRepo.findByStationIdIn(stationList
                    .stream().map(StationEntity::getId).collect(Collectors.toList()))
                    .parallelStream().forEach(b -> {
                List<BicycleEntity> l = bicycleMap.get(b.getStationId());
                if (CollectionUtils.isEmpty(l)) {
                    l = new ArrayList<>();
                }
                l.add(b);
                bicycleMap.put(b.getStationId(), l);
            });

            if (CollectionUtils.isEmpty(bicycleMap)) {
                stationList.parallelStream().map(s -> {
                    StationResp stationResp = new ModelMapper().map(s, StationResp.class);
                    List<BicycleEntity> bicycleList = bicycleMap.get(s.getId());
                    if(CollectionUtils.isEmpty(bicycleList)) {
                        stationResp.setSizeEmpty(s.getSize() - bicycleList.size());
                        stationResp.setListBicycle(bicycleList.parallelStream().map(b -> {
                            BicycleResp bRs = new ObjectMapper().convertValue(b, BicycleResp.class);
                            bRs.setType(appUntil.getBicycleType(b.getTypeId()));
                            return bRs;
                        }).collect(Collectors.toList()));
                    }
                    stationResp.setSizeEmpty(s.getSize());
                    return stationResp;
                }).collect(Collectors.toList());
            }

        }
        return rs;
    }

}
