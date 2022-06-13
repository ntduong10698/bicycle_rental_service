package vn.hust.edu.bicycle_rental_service.service;

import org.springframework.web.bind.annotation.RequestBody;
import vn.hust.edu.bicycle_rental_service.dto.response.PostRentBicycleResp;

public interface BicycleService {

    PostRentBicycleResp postRentBicycle(@RequestBody PostRentBicycleResp req);

}
