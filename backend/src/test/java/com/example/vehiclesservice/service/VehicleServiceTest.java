package com.example.vehiclesservice.service;

import com.example.vehiclesservice.api.Vehicle;
import com.example.vehiclesservice.exception.VehicleNotFoundException;
import com.example.vehiclesservice.model.VehicleEntity;
import com.example.vehiclesservice.repository.VehicleRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.example.vehiclesservice.constants.VehicleConstants.*;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VehicleServiceTest {
  /*  @Mock
    private VehicleRepository vehicleRepositoryMock;

    @Mock
    private VehicleEntity vehicleEntityMock;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = Vehicle.builder().description(V_DESCRIPTION).rented(V_RENTED).model(V_MODEL).pricePerDay(V_PRICE).build();

        when(vehicleRepositoryMock.save(vehicleEntityMock)).thenReturn(vehicleEntityMock);

        Vehicle newVehicle = vehicleService.addVehicle(vehicle);

        Assert.assertEquals(newVehicle, vehicle);
    }

    @Test
    public void testFindOne() throws VehicleNotFoundException {
        when(vehicleRepositoryMock.findById(DB_ID)).thenReturn(Optional.of(vehicleEntityMock));

        Vehicle vehicle = vehicleService.findOne(DB_ID);

        Assert.assertEquals(vehicle.getId(), vehicleEntityMock.getId());
    }

    @Test
    public void testFindOneException() {
        Assert.assertThrows(VehicleNotFoundException.class, () -> {
            when(vehicleRepositoryMock.findById(DB_ID_FALSE)).thenReturn(Optional.empty());

            vehicleService.findOne(DB_ID_FALSE);
        });
    }*/
}
