package com.example.vehiclesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.example.userservice.api"})
@EnableEurekaClient
@EnableFeignClients
public class VehiclesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesServiceApplication.class, args);
    }

}
