package vn.hust.edu.bicycle_rental_service.until;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.springframework.beans.factory.annotation.Autowired;
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

    public <T> T convertValue(Object data, Class<T> toValueType) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        return mapper.convertValue(data, toValueType);
    }

}
