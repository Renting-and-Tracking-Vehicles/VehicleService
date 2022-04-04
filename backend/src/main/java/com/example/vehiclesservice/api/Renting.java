package com.example.vehiclesservice.api;

import lombok.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Renting {
    private int id;
    private Vehicle vehicle;
    private int userId;
    private double totalPrice;
    private int durationInDays;
    private Date startDay;
    private Date endDay;
}
