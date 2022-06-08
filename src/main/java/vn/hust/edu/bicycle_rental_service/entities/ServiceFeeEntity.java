package vn.hust.edu.bicycle_rental_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "service_fee")
public class ServiceFeeEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String serviceType;

    private Integer bicycleTypeId;

    private Integer index;

    private BigDecimal fee;

}
