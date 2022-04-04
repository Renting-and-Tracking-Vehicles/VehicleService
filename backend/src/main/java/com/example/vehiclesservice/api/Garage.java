package com.example.vehiclesservice.api;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Garage {
    private int id;
    private Address address;
    private int capacity;
}
