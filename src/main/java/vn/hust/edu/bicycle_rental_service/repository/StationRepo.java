package vn.hust.edu.bicycle_rental_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hust.edu.bicycle_rental_service.entities.StationEntity;

import java.util.List;

@Repository
public interface StationRepo extends JpaRepository<StationEntity, Integer> {

    @Query("select s from StationEntity s where s.status = ?3 " +
            "and (?1 is null or s.name like concat('%',?1,'%')) " +
            "and (?2 is null or s.address like concat('%',?2,'%'))")
    List<StationEntity> findByNameAndAddressAndStatus(String name, String address, String status);

    @Query("select s from  StationEntity s where s.status = ?1 and s.id in ?2")
    List<StationEntity> findByStatusAndIdIn(String status, List<Integer> ids);
}
