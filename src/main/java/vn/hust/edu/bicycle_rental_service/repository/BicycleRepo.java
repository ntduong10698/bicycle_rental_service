package vn.hust.edu.bicycle_rental_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import vn.hust.edu.bicycle_rental_service.entities.BicycleEntity;

import java.util.List;

@Repository
public interface BicycleRepo extends JpaRepository<BicycleEntity, Integer> {

    @Query("select b from BicycleEntity b where b.stationId in ?1 and b.status = ?2")
    List<BicycleEntity> findByStationIdIn(List<Integer> listStationId, String status);

    @Query("select b from BicycleEntity b where (?1 is null or b.typeId in ?1) " +
            "and (?2 is null or b.name like concat('%', ?2, '%')) " +
            "and (?3 is null or b.weight <= ?3) " +
            "and (?4 is null or b.producer like concat('%',?4,'%')) " +
            "order by b.stationId desc")
    List<BicycleEntity> search(List<Integer> listType, String name, Float weight, String producer);
}
