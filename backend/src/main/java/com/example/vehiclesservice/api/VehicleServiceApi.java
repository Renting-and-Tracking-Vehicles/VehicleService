package com.example.vehiclesservice.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("vehicles-service")
public interface VehicleServiceApi {
}
