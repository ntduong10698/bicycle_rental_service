package vn.hust.edu.bicycle_rental_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hust.edu.bicycle_rental_service.entities.BicycleTypeEntity;

@Repository
public interface BicycleTypeRepo extends JpaRepository<BicycleTypeEntity, Integer> {
}
