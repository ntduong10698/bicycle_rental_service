package vn.hust.edu.bicycle_rental_service.service;

import vn.hust.edu.bicycle_rental_service.dto.request.PostListStationReq;
import vn.hust.edu.bicycle_rental_service.dto.response.PostListStationResp;

public interface StationService {

    PostListStationResp postListStation(PostListStationReq req);


}
