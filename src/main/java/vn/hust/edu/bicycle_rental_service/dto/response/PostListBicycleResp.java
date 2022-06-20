package vn.hust.edu.bicycle_rental_service.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PostListBicycleResp extends BicycleResp{
    private List<BicycleResp> listBicycle;
}
