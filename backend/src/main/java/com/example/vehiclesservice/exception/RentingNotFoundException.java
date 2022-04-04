package com.example.vehiclesservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Vehicle not found!")
public class RentingNotFoundException extends RuntimeException{}
