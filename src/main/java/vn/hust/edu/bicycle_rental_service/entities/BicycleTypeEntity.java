package vn.hust.edu.bicycle_rental_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "bicycle_type")
public class BicycleTypeEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6586018584514926581L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

}
