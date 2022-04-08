package com.example.vehiclesservice;

import com.example.userservice.api.UserServiceApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(clients = UserServiceApi.class)
public class VehiclesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesServiceApplication.class, args);
    }

}
