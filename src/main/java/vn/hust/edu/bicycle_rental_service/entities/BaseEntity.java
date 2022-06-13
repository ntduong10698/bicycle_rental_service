package vn.hust.edu.bicycle_rental_service.entities;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class BaseEntity {

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String status;

    @PrePersist
    public void prePersist() {
        createdAt = new Timestamp(new Date().getTime());
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Timestamp(new Date().getTime());
    }
}
