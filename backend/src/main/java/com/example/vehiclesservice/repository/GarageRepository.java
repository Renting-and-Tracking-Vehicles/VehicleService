package com.example.vehiclesservice.repository;

import com.example.vehiclesservice.model.GarageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<GarageEntity, Integer> {
}
