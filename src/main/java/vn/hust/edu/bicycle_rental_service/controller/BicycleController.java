package vn.hust.edu.bicycle_rental_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hust.edu.bicycle_rental_service.dto.response.PostRentBicycleResp;
import vn.hust.edu.bicycle_rental_service.service.BicycleService;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/bike"))
public class BicycleController {

    private final BicycleService bicycleService;

    @PostMapping
    public PostRentBicycleResp postRentBicycle(@RequestBody PostRentBicycleResp req) {
        return bicycleService.postRentBicycle(req);
    }

}



