package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.DTO.DriverDTO;
import com.example.priemraapi_rest.model.Driver;
import com.example.priemraapi_rest.projections.DriverResum;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<DriverResum> getAllDrivers();
    Optional<DriverDTO> getDriverByCode(String code);
    void saveDriver(Driver driver);
    void deleteDriverByCode(String code);

}
