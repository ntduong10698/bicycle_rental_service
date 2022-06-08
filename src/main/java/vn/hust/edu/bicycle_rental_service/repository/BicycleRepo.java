package vn.hust.edu.bicycle_rental_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hust.edu.bicycle_rental_service.entities.BicycleEntity;

import java.util.List;

@Repository
public interface BicycleRepo extends JpaRepository<BicycleEntity, Integer> {

    @Query("select b from BicycleEntity b where b.stationId in ?1")
    List<BicycleEntity> findByStationIdIn(List<Integer> listStationId);

}
