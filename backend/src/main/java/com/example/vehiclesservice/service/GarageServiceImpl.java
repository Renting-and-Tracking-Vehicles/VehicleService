package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Garage;
import com.example.vehiclesservice.helper.CollectionMapper;
import com.example.vehiclesservice.model.GarageEntity;
import com.example.vehiclesservice.repository.GarageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GarageServiceImpl implements GarageService{

    private final GarageRepository garageRepository;

    @Override
    public List<Garage> getAllGarages() {
        List<GarageEntity> garages = garageRepository.findAll();
        return CollectionMapper.mapList(garages, Garage.class);
    }
}
