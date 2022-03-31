package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Renting;
import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.RentingNotFoundException;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.model.RentingEntity;
import com.example.vehiclesservice.repository.RentingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentingServiceImpl implements RentingService{

    private final RentingRepository rentingRepository;
    private final VehicleService vehicleService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Renting startRenting(Renting renting) throws VehicleNotFoundException {
        RentingEntity rentingEntity = modelMapper.map(renting, RentingEntity.class);
        changeCarStatusToRented(rentingEntity);
        rentingRepository.save(rentingEntity);
        return renting;
    }

    private void changeCarStatusToRented(RentingEntity rentingEntity) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleService.findOne(rentingEntity.getVehicle().getId());
        vehicle.setRented(true);
        vehicleService.editVehicle(vehicle);
    }

    @Override
    public void finishRenting(Integer id) {
        Renting renting = getRentingById(id);
        Vehicle vehicle = renting.getVehicle();
        vehicle.setRented(false);
        vehicleService.editVehicle(vehicle);
    }

    @Override
    public List<Renting> getRentingsByUserId(int userId) {
        List<RentingEntity> rentings = rentingRepository.getRentingByUserId(userId);
        return mapList(rentings, Renting.class);
    }

    @Override
    public Renting getRentingById(int id) {
        Optional<RentingEntity> renting = rentingRepository.findById(id);
        if(renting.isPresent())
            return modelMapper.map(renting.get(), Renting.class);

        throw new RentingNotFoundException();
    }

    private <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }
}