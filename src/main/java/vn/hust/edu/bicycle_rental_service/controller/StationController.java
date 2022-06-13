package vn.hust.edu.bicycle_rental_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hust.edu.bicycle_rental_service.dto.request.PostListStationReq;
import vn.hust.edu.bicycle_rental_service.dto.response.PostListStationResp;
import vn.hust.edu.bicycle_rental_service.service.StationService;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/station"))
public class StationController {

    private final StationService stationService;

    @PostMapping
    public PostListStationResp postListStation(@RequestBody PostListStationReq req) {
        return stationService.postListStation(req);
    }

}
