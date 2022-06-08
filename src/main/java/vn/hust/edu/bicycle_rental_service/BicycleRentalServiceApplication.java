package vn.hust.edu.bicycle_rental_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BicycleRentalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleRentalServiceApplication.class, args);
    }

}
