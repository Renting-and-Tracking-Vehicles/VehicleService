package com.example.vehiclesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class Address {

    private int id;
    private String street;
    private String number;
    private String city;
    private String postalcode;
    private String country;
    private double longitude;
    private double latitude;
}
