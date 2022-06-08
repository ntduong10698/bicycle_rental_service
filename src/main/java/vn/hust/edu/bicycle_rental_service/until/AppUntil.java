package vn.hust.edu.bicycle_rental_service.until;

import org.springframework.stereotype.Component;
import vn.hust.edu.bicycle_rental_service.config.AppConfig;
import vn.hust.edu.bicycle_rental_service.entities.BicycleTypeEntity;

import java.util.Objects;

@Component
public class AppUntil {

    public String getBicycleType(Integer bicycleTypeId) {
        BicycleTypeEntity type = AppConfig.mapTypeBicycle.get(bicycleTypeId);
        return Objects.nonNull(type) ? type.getName() : null;
    }

}
