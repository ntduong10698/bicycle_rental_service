package vn.hust.edu.bicycle_rental_service.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vn.hust.edu.bicycle_rental_service.config.AppConfig;
import vn.hust.edu.bicycle_rental_service.entities.BicycleTypeEntity;
import vn.hust.edu.bicycle_rental_service.repository.BicycleTypeRepo;
import vn.hust.edu.bicycle_rental_service.type.StatusType;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Log4j2
@RequiredArgsConstructor
public class AppSchedule {

    private final BicycleTypeRepo bicycleTypeRepo;

    @Scheduled(fixedRate = 8460000)
    public void loadBicycleType() {
        log.info("====Start AppSchedule loadBicycleType====");
        List<BicycleTypeEntity> listBicycleType = bicycleTypeRepo.findByStatus(StatusType.ACTIVE.name());
        AppConfig.mapTypeBicycle = listBicycleType.parallelStream()
                .collect(Collectors.toMap(BicycleTypeEntity::getId, Function.identity()));
    }
}
