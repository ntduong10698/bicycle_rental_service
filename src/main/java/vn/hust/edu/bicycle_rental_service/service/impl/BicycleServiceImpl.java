package vn.hust.edu.bicycle_rental_service.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import vn.hust.edu.bicycle_rental_service.config.AppConfig;
import vn.hust.edu.bicycle_rental_service.dto.request.PostListBicycleReq;
import vn.hust.edu.bicycle_rental_service.dto.request.PostRentBicycleReq;
import vn.hust.edu.bicycle_rental_service.dto.response.BicycleResp;
import vn.hust.edu.bicycle_rental_service.dto.response.PostListBicycleResp;
import vn.hust.edu.bicycle_rental_service.dto.response.PostRentBicycleResp;
import vn.hust.edu.bicycle_rental_service.entities.BicycleEntity;
import vn.hust.edu.bicycle_rental_service.entities.StationEntity;
import vn.hust.edu.bicycle_rental_service.repository.BicycleRepo;
import vn.hust.edu.bicycle_rental_service.repository.StationRepo;
import vn.hust.edu.bicycle_rental_service.service.BicycleService;
import vn.hust.edu.bicycle_rental_service.type.StatusType;
import vn.hust.edu.bicycle_rental_service.until.AppUntil;
import vn.hust.edu.bicycle_rental_service.validator.ValidatorApp;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BicycleServiceImpl implements BicycleService {

    private final BicycleRepo bicycleRepo;

    private final StationRepo stationRepo;

    private final AppUntil appUntil;

    private final ValidatorApp validatorApp;

    @Override
    public PostRentBicycleResp postRentBicycle(PostRentBicycleReq req) {
        try {
            //validate input
            if(!validatorApp.validateServiceApp(req.getServiceType()))
                return PostRentBicycleResp.builder()
                        .status(false)
                        .message("service type is invalid")
                        .build();

            if(!validatorApp.validateCardInfo(req.getCardNumber(), req.getIssuingDate(),
                    req.getExpirationDate(), req.getSecurityCode()))
                return PostRentBicycleResp.builder()
                        .status(false)
                        .message("card info is invalid")
                        .build();

            //check thong tin xe
            //check thong tin thanh toan
                //check trung thong tin thanh toan
                //check so du

            //tru phi
            //ghi thong tin hoa don
            //set stationId bicycle null
            //map description
            return null;
        } catch (Exception e) {
            log.error("==== Error BicycleServiceImpl postRentBicycle with error: {}", e);
            throw e;
        }
    }

    @Override
    public PostListBicycleResp postListBicyCleResp(PostListBicycleReq req) {
        try {
            PostListBicycleResp rs = new PostListBicycleResp();

            //validate
            List<Integer> listType = null;
            if (Objects.nonNull(req.getTypeId())) {
                listType = req.getTypeId().stream().filter(t ->
                        Objects.nonNull(AppConfig.mapTypeBicycle.get(t))
                ).collect(Collectors.toList());
            }
            listType = CollectionUtils.isEmpty(listType) ? null : listType;

            //find bicycle
            List<BicycleEntity> listBicycle = bicycleRepo.search(listType, req.getName(), req.getWeight(),
                    req.getProducer());

            if(CollectionUtils.isEmpty(listBicycle))
                return rs;

            //find station
            List<Integer> listStationId = new ArrayList<>();
            listStationId.addAll(listBicycle.stream()
                    .map(BicycleEntity::getStationId).collect(Collectors.toSet()));
            List<StationEntity> listStation = stationRepo.findByStatusAndIdIn(StatusType.ACTIVE.name(),
                    listStationId);

            if(CollectionUtils.isEmpty(listStation))
                return rs;

            //map data
            rs.setListBicycle(new ArrayList<>());
            listStation.forEach(s -> {
                listBicycle.forEach(b -> {
                    if(b.getStationId().equals(s.getId())) {
                        BicycleResp r = appUntil.convertValue(b, BicycleResp.class);
                        r.setStationAddress(s.getAddress());
                        r.setType(appUntil.getBicycleType(b.getTypeId()));
                        rs.getListBicycle().add(r);
                    }
                });
            });
            return rs;
        } catch (Exception e) {
            log.error("==== Error BicycleServiceImpl postListBicyCleResp with error: {}", e);
            throw e;
        }
    }

}
