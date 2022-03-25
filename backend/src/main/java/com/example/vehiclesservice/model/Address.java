package com.example.vehiclesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter@Setter@NoArgsConstructor
@Entity
public class Address {

    @Id
    @SequenceGenerator(name = "addressSeqGen", sequenceName = "addressSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressSeqGen")
    @Column(name="address_id", unique=true, nullable=false)
    private int id;
    @Column(name="street_name", nullable=false)
    private String streetName;
    @Column(name="street_number", nullable=false)
    private String streetNumber;
    @Column(name="city", nullable=false)
    private String city;
    @Column(name="postal_code")
    private String postalCode;
    @Column(name="country", nullable = false)
    private String country;
    @Column(name="longitude", nullable = false)
    private double longitude;
    @Column(name="latitude", nullable = false)
    private double latitude;
}
