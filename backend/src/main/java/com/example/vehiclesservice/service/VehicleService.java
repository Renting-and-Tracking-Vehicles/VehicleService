package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);

    Vehicle findOne(Integer id) throws VehicleNotFoundException;

    List<Vehicle> findAll();

    Vehicle editVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);

    List<Vehicle> findAllAvailableVehicles();
}
