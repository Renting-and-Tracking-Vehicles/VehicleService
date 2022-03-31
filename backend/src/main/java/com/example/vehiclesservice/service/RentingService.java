package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Renting;
import com.example.vehiclesservice.exception.VehicleNotFoundException;

import java.util.List;

public interface RentingService {

    Renting startRenting(Renting renting) throws VehicleNotFoundException;

    List<Renting> getRentingsByUserId(int userId);

    Renting getRentingById(int id);

    void finishRenting(Integer id);
}
