package com.example.vehiclesservice.repository;

import com.example.vehiclesservice.model.RentingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentingRepository extends JpaRepository<RentingEntity, Integer> {

    List<RentingEntity> getRentingByUserId(Integer id);
}
