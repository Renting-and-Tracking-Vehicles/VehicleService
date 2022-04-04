package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Renting;
import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.RentingNotFoundException;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.helper.CollectionMapper;
import com.example.vehiclesservice.model.RentingEntity;
import com.example.vehiclesservice.repository.RentingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentingServiceImpl implements RentingService{

    private final RentingRepository rentingRepository;
    private final VehicleService vehicleService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = false)
    public Renting startRenting(Renting renting) throws VehicleNotFoundException {
        RentingEntity rentingEntity = modelMapper.map(renting, RentingEntity.class);
        changeCarStatusToRented(renting.getVehicle());
        rentingRepository.save(rentingEntity);
        return renting;
    }

    @Override
    public Renting finishRenting(Renting renting) throws  OptimisticLockException{
        changeCarStatusToAvailable(renting.getVehicle());
        RentingEntity rentingEntity = modelMapper.map(renting, RentingEntity.class);
        rentingRepository.save(rentingEntity);
        return renting;
    }

    private void changeCarStatusToRented(Vehicle vehicle) {
        vehicle.setRented(true);
        vehicleService.editVehicle(vehicle);
    }

    private void changeCarStatusToAvailable(Vehicle vehicle) {
        vehicle.setRented(false);
        vehicleService.editVehicle(vehicle);
    }

    @Override
    public List<Renting> getCurrentRentingsByUserId(int userId) {
        List<RentingEntity> rentings = rentingRepository.getRentingByUserId(userId).stream().filter(r -> r.getEndDay() == null).collect(Collectors.toList());
        return CollectionMapper.mapList(rentings, Renting.class);
    }

    @Override
    public Renting getRentingById(int id) throws RentingNotFoundException {
        Optional<RentingEntity> renting = rentingRepository.findById(id);
        if(renting.isPresent())
            return modelMapper.map(renting.get(), Renting.class);

        throw new RentingNotFoundException();
    }
}