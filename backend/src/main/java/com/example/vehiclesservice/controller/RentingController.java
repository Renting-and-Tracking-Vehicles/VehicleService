package com.example.vehiclesservice.controller;

import com.example.vehiclesservice.api.Renting;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.service.RentingService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/vehicles/renting", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class RentingController {

    private RentingService rentingService;

    @PostMapping("/start-renting")
    public Renting startRenting(@RequestBody Renting renting) throws ObjectOptimisticLockingFailureException {
        return rentingService.startRenting(renting);
    }

    @PutMapping("/finish-renting")
    public Renting finishRenting(@RequestBody Renting renting) { return rentingService.finishRenting(renting); }

    @GetMapping("/current-rentings/{id}")
    public Iterable<Renting> getUserRentings(@PathVariable("id") Integer id) { return rentingService.getCurrentRentingsByUserId(id); }

    @GetMapping("/rentings-history/{id}")
    public Iterable<Renting> getUserHistoryOfRentings(@PathVariable("id") Integer id) { return rentingService.getRentingHistoryByUserId(id); }
}
