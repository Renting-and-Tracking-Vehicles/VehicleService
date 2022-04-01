package com.example.vehiclesservice.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor@AllArgsConstructor @Builder
public class Garage {
    private int id;
    private Address address;
    private int capacity;
}
