package com.example.vehiclesservice.api;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private int id;
    private String streetName;
    private String streetNumber;
    private String city;
    private String postalCode;
    private String country;
    private double longitude;
    private double latitude;
}
