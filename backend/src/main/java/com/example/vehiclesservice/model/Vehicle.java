package com.example.vehiclesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter@Setter@NoArgsConstructor
public class Vehicle {
    private int id;
    private String model;
    private String description;
    private double pricePerDay;
    private Address address;
    private Set<String> images;
    private Boolean rented;
}
