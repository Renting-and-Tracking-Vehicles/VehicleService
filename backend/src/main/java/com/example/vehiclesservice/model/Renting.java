package com.example.vehiclesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter@Setter@NoArgsConstructor
public class Renting {
    @Id
    @SequenceGenerator(name = "rentingSeqGen", sequenceName = "rentingSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rentingSeqGen")
    @Column(name="renting_id", unique=true, nullable=false)
    private int id;
    @Column(name="rented_vehicle_id")
    private int rentedVehicleId;
    @Column(name="user_id")
    private int userId;
    @Column(name="total_price")
    private double totalPrice;
    @Column(name="duration_in_days")
    private int durationInDays;
    @Column(name="start_day")
    private Date startDay;
}
