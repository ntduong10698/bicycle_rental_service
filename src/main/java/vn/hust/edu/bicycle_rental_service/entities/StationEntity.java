package vn.hust.edu.bicycle_rental_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "station")
public class StationEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7277221864762157624L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String location;

    private Integer size;

    private String address;

}
