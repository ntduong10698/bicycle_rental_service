package vn.hust.edu.bicycle_rental_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hust.edu.bicycle_rental_service.entities.ServiceFeeEntity;

@Repository
public interface ServiceFeeRepo extends JpaRepository<ServiceFeeEntity, Integer> {
}
