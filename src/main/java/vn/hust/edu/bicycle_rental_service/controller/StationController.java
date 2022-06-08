package vn.hust.edu.bicycle_rental_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hust.edu.bicycle_rental_service.dto.response.GetListStationResp;
import vn.hust.edu.bicycle_rental_service.service.StationService;

@Log4j2
@RequiredArgsConstructor
@RestController("/api/v1/station")
public class StationController {

    private final StationService stationService;

    @GetMapping
    public GetListStationResp getListStation() {
        return stationService.getListStation();
    }

}
