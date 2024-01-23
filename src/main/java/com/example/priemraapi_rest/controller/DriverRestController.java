package com.example.priemraapi_rest.controller;

import com.example.priemraapi_rest.DTO.DriverDTO;
import com.example.priemraapi_rest.model.Driver;
import com.example.priemraapi_rest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    private final DriverService driveService;

    @Autowired
    public DriverRestController(DriverService driveService) {
        this.driveService = driveService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(driveService.getAllDrivers());
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<DriverDTO> getByCode(@PathVariable String code) {
        return this.driveService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        if (driver.getDriverId() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.driveService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }
    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        this.driveService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }
    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> delete(@PathVariable String code) {
        this.driveService.deleteDriverByCode(code);
        return  ResponseEntity.noContent().build();
    }
}
