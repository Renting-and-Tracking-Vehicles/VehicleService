package com.example.vehiclesservice.controller;

import com.example.vehiclesservice.api.Renting;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.service.RentingService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/renting", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class RentingController {

    private RentingService rentingService;

    @PostMapping("/startRenting")
    public Renting startRenting(@RequestBody Renting renting) throws VehicleNotFoundException {
        System.out.println(renting.toString());
        return rentingService.startRenting(renting);
    }

    @DeleteMapping("/finishRenting/{id}")
    public void finishRenting(@PathVariable("id") Integer id) {  rentingService.finishRenting(id); }

    @GetMapping("/userRentings/{id}")
    public Iterable<Renting> getUserRentings(@PathVariable("id") Integer id) { return rentingService.getRentingsByUserId(id); }
}
