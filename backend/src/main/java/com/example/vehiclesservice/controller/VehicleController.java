package com.example.vehiclesservice.controller;

import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.service.VehicleService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping("/getVehicle/{vehicleId}")
    public Vehicle getVehicles(@PathVariable("vehicleId") Integer id) throws VehicleNotFoundException { return vehicleService.findOne(id); }

    @GetMapping("/getVehicle")
    public Iterable<Vehicle> getVehicles(){
        return vehicleService.findAll();
    }

    @GetMapping("/getAvailableVehicles")
    public Iterable<Vehicle> getAvailableVehicles(){
        return vehicleService.findAllAvailableVehicles();
    }

    @DeleteMapping("/deleteVehicle/{vehicleId}")
    public void deleteVehicle(@PathVariable("vehicleId") Integer id){
        vehicleService.deleteVehicle(id);
    }

    @PutMapping("/editVehicle/{vehicleId}")
    public Vehicle editVehicle(@PathVariable("vehicleId") Integer id, @RequestBody Vehicle newVehicle) throws VehicleNotFoundException{
        Vehicle editedVehicle = vehicleService.findOne(id);
        newVehicle.setId(id);
        return vehicleService.addVehicle(newVehicle);
    }
}
