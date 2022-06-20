package vn.hust.edu.bicycle_rental_service.service;

import vn.hust.edu.bicycle_rental_service.dto.request.PostListBicycleReq;
import vn.hust.edu.bicycle_rental_service.dto.request.PostRentBicycleReq;
import vn.hust.edu.bicycle_rental_service.dto.response.PostListBicycleResp;
import vn.hust.edu.bicycle_rental_service.dto.response.PostRentBicycleResp;

public interface BicycleService {

    PostRentBicycleResp postRentBicycle(PostRentBicycleReq req);

    PostListBicycleResp postListBicyCleResp(PostListBicycleReq req);
}
