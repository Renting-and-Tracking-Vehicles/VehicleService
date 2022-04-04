package com.example.vehiclesservice.api;

import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    private int id;
    private String model;
    private String description;
    private double pricePerDay;
    private Garage garage;
    private Set<String> images;
    private Boolean rented;
    private Integer version;
}
