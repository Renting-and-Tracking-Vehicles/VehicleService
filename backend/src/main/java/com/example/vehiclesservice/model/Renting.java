package com.example.vehiclesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter@Setter@NoArgsConstructor
public class Renting {
    private int id;
    private int rentedVehicleId;
    private int userId;
    private double totalPrice;
    private int durationInDays;
    private Date startDay;
}
