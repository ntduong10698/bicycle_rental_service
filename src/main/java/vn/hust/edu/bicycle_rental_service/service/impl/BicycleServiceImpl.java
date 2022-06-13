package vn.hust.edu.bicycle_rental_service.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import vn.hust.edu.bicycle_rental_service.dto.response.PostRentBicycleResp;
import vn.hust.edu.bicycle_rental_service.service.BicycleService;

@Service
@Log4j2
@RequiredArgsConstructor
public class BicycleServiceImpl implements BicycleService {

    @Override
    public PostRentBicycleResp postRentBicycle(PostRentBicycleResp req) {
        try {


        } catch (Exception e) {
            log.error("==== Error BicycleServiceImpl postRentBicycle with error: {}", e);
            throw e;
        }
    }

}
