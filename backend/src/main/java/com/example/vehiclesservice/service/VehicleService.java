package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Vehicle;
import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);

    Vehicle findOne(Integer id);

    List<Vehicle> findAll();

    Vehicle editVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);

    List<Vehicle> findAllAvailableVehicles();
}
