package com.example.vehiclesservice.api;

import com.example.vehiclesservice.model.Garage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicle {
    private int id;
    private String model;
    private String description;
    private double pricePerDay;
    private Garage garage;
    private Set<String> images;
    private Boolean rented;
}
