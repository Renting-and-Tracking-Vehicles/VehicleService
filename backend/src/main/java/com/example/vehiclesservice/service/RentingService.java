package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Renting;

import java.util.List;

public interface RentingService {

    Renting startRenting(Renting renting);

    List<Renting> getCurrentRentingsByUserId(int userId);

    List<Renting> getRentingHistoryByUserId(int userId);

    Renting getRentingById(int id);

    Renting finishRenting(Renting renting);
}
