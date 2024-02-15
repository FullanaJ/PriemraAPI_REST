package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.DTO.DriverDTO;
import com.example.priemraapi_rest.maper.DriverMapper;
import com.example.priemraapi_rest.model.Driver;
import com.example.priemraapi_rest.projections.DriverResum;
import com.example.priemraapi_rest.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public List<DriverResum> getAllDrivers() {

        return driverRepository.findAllProjectedBy();
    }
    public Optional<DriverDTO> getDriverByCode(String code) {
        return driverRepository.findByCodeIgnoreCase(code)
                .map(driverMapper);
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
