package vn.hust.edu.bicycle_rental_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "bicycle")
public class BicycleEntity extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -5710556117210755223L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer typeId;

    private Integer stationId;

    private String name;

    private String licensePlate;

    private Date manufacturingDate;

    private String producer;

    private Float weight;

    private Float batteryPercentage;

    private Integer loadCycles;

    private Integer timeRemaining;

}
