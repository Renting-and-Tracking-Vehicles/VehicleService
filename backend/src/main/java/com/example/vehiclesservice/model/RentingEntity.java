package com.example.vehiclesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter@Setter@NoArgsConstructor
public class RentingEntity {
    @Id
    @SequenceGenerator(name = "rentingSeqGen", sequenceName = "rentingSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rentingSeqGen")
    @Column(name="renting_id", unique=true, nullable=false)
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicle;
    @Column(name="user_id")
    private int userId;
    @Column(name="total_price")
    private double totalPrice;
    @Column(name="duration_in_days")
    private int durationInDays;
    @Column(name="start_day")
    private Date startDay;
}
