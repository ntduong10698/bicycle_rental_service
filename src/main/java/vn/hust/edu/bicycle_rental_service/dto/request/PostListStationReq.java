package vn.hust.edu.bicycle_rental_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostListStationReq {
    private String name;
    private String address;
    private Boolean isEmpty;
}
