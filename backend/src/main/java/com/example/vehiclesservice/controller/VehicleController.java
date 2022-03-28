package com.example.vehiclesservice.controller;

import com.example.vehiclesservice.model.Vehicle;
import com.example.vehiclesservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;


@RestController
@RequestMapping(value = "/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @PostMapping("/addVehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping("/getVehicle/{vehicleId}")
    public Optional<Vehicle> getVehicles(@PathVariable("vehicleId") Integer id){
        return vehicleService.findOne(id);
    }

    @GetMapping("/getVehicle")
    public Iterable<Vehicle> getVehicles(){
        return vehicleService.findAll();
    }

    @DeleteMapping("/deleteVehicle/{vehicleId}")
    public void deleteVehicle(@PathVariable("vehicleId") Integer id){
        vehicleService.deleteVehicle(id);
    }

    @PutMapping("/editVehicle/{vehicleId}")
    public Vehicle editVehicle(@PathVariable("vehicleId") Integer id, @RequestBody Vehicle newVehicle){
        Optional<Vehicle> editedVehicle = vehicleService.findOne(id);

        if(editedVehicle != null){
            newVehicle.setId(id);

//            add je jer je trenutno funkcija u servisu sa save
            return vehicleService.addVehicle(newVehicle);
        }
        return null;

    }
}
