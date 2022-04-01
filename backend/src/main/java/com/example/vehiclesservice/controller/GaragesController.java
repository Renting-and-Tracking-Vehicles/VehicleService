package com.example.vehiclesservice.controller;

import com.example.vehiclesservice.api.Garage;
import com.example.vehiclesservice.service.GarageService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/garage", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class GaragesController {

    private final GarageService garageService;

    @GetMapping("/getAll")
    public Iterable<Garage> getAllGarages() { return garageService.getAllGarages(); }
}
