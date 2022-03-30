package com.example.vehiclesservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleEntity {
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
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "garage_id")
    private Garage garage;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vehicle_images", joinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<String> images;
    @Column(name="is_rented", nullable=false)
    private Boolean rented;
}
