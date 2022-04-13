package com.example.vehiclesservice.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GarageEntity {
    @Id
    @SequenceGenerator(name = "garageSeqGen", sequenceName = "garageSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garageSeqGen")
    @Column(name="garage_id", unique=true, nullable=false)
    private int id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddressEntity address;
    @Column(name = "capacity", nullable = false)
    private int capacity;
}
