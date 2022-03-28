package com.example.vehiclesservice.service;

import com.example.userservice.api.RegisteredUser;
import com.example.userservice.api.UserServiceApi;
import com.example.vehiclesservice.model.Vehicle;
import com.example.vehiclesservice.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public Optional<Vehicle> findOne(Integer id){
        System.out.println(userServiceApi.getUser(id).toString());
        return vehicleRepository.findById(id);
    }

    @Override
    public Iterable<Vehicle> findAll() { return vehicleRepository.findAll(); }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
