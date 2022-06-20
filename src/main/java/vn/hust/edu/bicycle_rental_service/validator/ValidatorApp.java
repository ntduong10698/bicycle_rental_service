package vn.hust.edu.bicycle_rental_service.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import vn.hust.edu.bicycle_rental_service.type.ServiceType;

import java.sql.Date;

@Component
@Log4j2
@RequiredArgsConstructor
public class ValidatorApp {

    public static final String patternCardNumber = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";

    public static final String patternSecurityCode = "^[0-9]{3,4}$";

    public boolean validateServiceApp(String serviceType) {
        try {
            ServiceType.valueOf(serviceType);
        } catch (Exception e) {
            log.error("==== Error ValidatorApp validateServiceApp with ex: ", e);
            return false;
        }
        return true;
    }

    public boolean validateCardInfo(String cardNumber, Date issuingDate, Date expirationDate, String securityCode) {
        if(!cardNumber.matches(patternCardNumber))
            return false;

        java.util.Date now = new java.util.Date();
        if(!(issuingDate.getTime() < expirationDate.getTime()
                && expirationDate.getTime() < now.getTime()))
            return false;

        if(!securityCode.matches(patternSecurityCode))
            return false;

        return true;
    }
}
