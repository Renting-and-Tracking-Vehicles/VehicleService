package com.example.vehiclesservice;

import com.example.userservice.api.UserServiceApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = UserServiceApi.class)
public class VehiclesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesServiceApplication.class, args);
    }

}
