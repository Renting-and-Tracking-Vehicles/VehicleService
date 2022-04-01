package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Garage;
import com.example.vehiclesservice.model.GarageEntity;
import com.example.vehiclesservice.repository.GarageRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GarageServiceImpl implements GarageService{

    private final GarageRepository garageRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Garage> getAllGarages() {
        List<GarageEntity> garages = garageRepository.findAll();
        return mapList(garages, Garage.class);
    }

    private <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }
}
