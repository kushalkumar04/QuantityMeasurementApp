package com.apps.quantitymeasurement;
/*
 * Spring Boot application entry point.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantityMeasurementApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                QuantityMeasurementApplication.class,
                args
        );
    }
}