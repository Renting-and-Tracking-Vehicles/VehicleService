package com.example.vehiclesservice.service;

import com.example.userservice.api.UserServiceApi;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.model.Vehicle;
import com.example.vehiclesservice.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserServiceApi userServiceApi;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> findOne(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
         return Optional.ofNullable(vehicle);
    }

    @Override
    public Iterable<Vehicle> findAll() { return vehicleRepository.findAll(); }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
