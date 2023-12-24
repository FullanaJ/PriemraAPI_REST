package com.example.priemraapi_rest.controller;

import com.example.priemraapi_rest.model.Driver;
import com.example.priemraapi_rest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driveService.getAllDrivers());
    }

}
