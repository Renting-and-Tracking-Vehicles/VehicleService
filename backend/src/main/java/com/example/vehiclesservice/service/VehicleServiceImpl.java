package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.helper.CollectionMapper;
import com.example.vehiclesservice.model.VehicleEntity;
import com.example.vehiclesservice.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = modelMapper.map(vehicle, VehicleEntity.class);
        vehicleRepository.save(vehicleEntity);
        return vehicle;
    }

    @Override
    public Vehicle findOne(Integer id)  {
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent())
            return modelMapper.map(vehicle.get(), Vehicle.class);

        throw new VehicleNotFoundException();
    }

    @Override
    public List<Vehicle> findAll() {
        List<VehicleEntity> vehicles = vehicleRepository.findAll();
        return CollectionMapper.mapList(vehicles, Vehicle.class);
    }

    @Override
    public Vehicle editVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = modelMapper.map(vehicle, VehicleEntity.class);
        vehicleRepository.save(vehicleEntity);
        return vehicle;
    }

    @Override
    public void deleteVehicle(Integer id) { vehicleRepository.deleteById(id); }

    @Override
    public List<Vehicle> findAllAvailableVehicles() {
        List<VehicleEntity> vehicles = vehicleRepository.findAll().stream().filter(v -> v.getRented() == false).collect(Collectors.toList());
        return CollectionMapper.mapList(vehicles, Vehicle.class);
    }
}
