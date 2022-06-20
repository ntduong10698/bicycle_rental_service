package vn.hust.edu.bicycle_rental_service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.sql.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private String stationAddress;
}
