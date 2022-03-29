package com.example.vehiclesservice.repository;

import com.example.vehiclesservice.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {

}
