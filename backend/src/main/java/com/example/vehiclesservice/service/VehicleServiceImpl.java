package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
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
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = modelMapper.map(vehicle, VehicleEntity.class);
        vehicleRepository.save(vehicleEntity);
        return vehicle;
    }

    @Override
    public Vehicle findOne(Integer id) throws VehicleNotFoundException {
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent())
            return modelMapper.map(vehicle.get(), Vehicle.class);

        throw new VehicleNotFoundException();
    }

    @Override
    public List<Vehicle> findAll() {
        List<VehicleEntity> vehicles = vehicleRepository.findAll();
        return mapList(vehicles, Vehicle.class);
    }

    @Override
    public void deleteVehicle(Integer id) { vehicleRepository.deleteById(id); }

    private <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }
}
