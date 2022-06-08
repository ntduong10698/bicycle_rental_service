package vn.hust.edu.bicycle_rental_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationResp {

    private Integer id;

    private String name;

    private String location;

    private Integer sizeEmpty;

    private String address;

    private List<BicycleResp> listBicycle;

}
