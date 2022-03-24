package com.example.vehiclesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter@Setter@NoArgsConstructor
public class Vehicle {
    @Id
    @SequenceGenerator(name = "vehicleSeqGen", sequenceName = "vehicleSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicleSeqGen")
    @Column(name="vehicle_id", unique=true, nullable=false)
    private int id;
    @Column(name="model", nullable=false)
    private String model;
    @Column(name="description", nullable=false)
    private String description;
    @Column(name="price_per_day", nullable=false)
    private double pricePerDay;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vehicle_images", joinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<String> images;
    @Column(name="is_rented", nullable=false)
    private Boolean rented;
}
