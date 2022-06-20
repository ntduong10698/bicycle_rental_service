package vn.hust.edu.bicycle_rental_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hust.edu.bicycle_rental_service.entities.BicycleTypeEntity;

import java.util.List;

@Repository
public interface BicycleTypeRepo extends JpaRepository<BicycleTypeEntity, Integer> {
    
    List<BicycleTypeEntity> findByStatus(String status);
}
