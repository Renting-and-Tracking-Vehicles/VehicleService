package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Renting;
import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.RentingNotFoundException;
import com.example.vehiclesservice.helper.CollectionMapper;
import com.example.vehiclesservice.model.RentingEntity;
import com.example.vehiclesservice.repository.RentingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    public Renting startRenting(Renting renting) {
        try {
            RentingEntity rentingEntity = modelMapper.map(renting, RentingEntity.class);
            changeCarStatusToRented(renting.getVehicle());
        }catch(ObjectOptimisticLockingFailureException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vehicle is already reserved!");
        }
        return renting;
    }

    @Override
    public Renting finishRenting(Renting renting) {
        changeCarStatusToAvailable(renting.getVehicle());
        RentingEntity rentingEntity = modelMapper.map(renting, RentingEntity.class);
        rentingRepository.save(rentingEntity);
        return renting;
    }

    @Transactional(readOnly = false)
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
    public List<Renting> getRentingHistoryByUserId(int userId) {
        List<RentingEntity> rentings = rentingRepository.getRentingByUserId(userId).stream().filter(r -> r.getEndDay() != null).collect(Collectors.toList());
        return CollectionMapper.mapList(rentings, Renting.class);
    }

    @Override
    public Renting getRentingById(int id) {
        Optional<RentingEntity> renting = rentingRepository.findById(id);
        if(renting.isPresent())
            return modelMapper.map(renting.get(), Renting.class);

        throw new RentingNotFoundException();
    }
}