package com.example.vehiclesservice.service;

import com.example.vehiclesservice.model.Vehicle;

import java.util.Optional;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);

    Optional<Vehicle> findOne(Integer id);

    Iterable<Vehicle> findAll();

    void deleteVehicle(Integer id);


}
