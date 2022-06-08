package vn.hust.edu.bicycle_rental_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity implements Serializable {

    @Id
    private String id;

    private Integer bicycleId;

    private BigDecimal price;

    private String serviceType;

    private String cardNumber;

    private String cardHolderName;

    private Date issuingDate;

    private Date expirationDate;

    private String securityCode;

    private String transactionDescription;
    
}
