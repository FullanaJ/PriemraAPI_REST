package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Driver;
import com.example.priemraapi_rest.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
    public Optional<Driver> getDriverByCode(String code) {
        return driverRepository.findByCodeIgnoreCase(code);
    }

    @Override
    public void saveDriver(Driver driver) {
        this.driverRepository.save(driver);
    }

    @Override
    public void deleteDriverByCode(String code) {
        this.driverRepository.deleteById(Long.parseLong(code));
    }
}
