package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers() ;
}
