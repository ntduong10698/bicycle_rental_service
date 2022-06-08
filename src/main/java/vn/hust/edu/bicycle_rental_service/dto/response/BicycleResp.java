package vn.hust.edu.bicycle_rental_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BicycleResp {

    private Integer id;

    private String type;

    private String name;

    private String licensePlate;

    private Date manufacturingDate;

    private String producer;

    private Float weight;

    private Float batteryPercentage;

    private Integer loadCycles;

    private Integer timeRemaining;

}
