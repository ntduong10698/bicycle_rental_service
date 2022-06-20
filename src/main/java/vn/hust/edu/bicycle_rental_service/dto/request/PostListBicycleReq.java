package vn.hust.edu.bicycle_rental_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostListBicycleReq {
    private List<Integer> typeId;
    private String name;
    private Float weight;
    private String producer;
}
