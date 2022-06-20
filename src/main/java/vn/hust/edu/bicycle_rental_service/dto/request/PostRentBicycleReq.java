package vn.hust.edu.bicycle_rental_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRentBicycleReq {
    @NotNull
    private Integer bicycleId;
    @NotEmpty
    private String serviceType;
    @NotEmpty
    private String cardNumber;
    @NotEmpty
    private String cardHolderName;
    @NotNull
    private Date issuingDate;
    @NotNull
    private Date expirationDate;
    @NotEmpty
    private String securityCode;
}
