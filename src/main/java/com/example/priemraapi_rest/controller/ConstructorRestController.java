package com.example.priemraapi_rest.controller;

import com.example.priemraapi_rest.model.Constructor;
import com.example.priemraapi_rest.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConstructorRestController {

    private final ConstructorService constructorService;
    @Autowired
    public ConstructorRestController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }
    @GetMapping("/constructors")
    public List<Constructor> getAllConstructors() {
        return constructorService.getAllConstructors();
    }

    @GetMapping("/constructors/{code}")
    public ResponseEntity<Constructor> getByCode(String code) {
        return this.constructorService.findByNameIgnoreCase(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
