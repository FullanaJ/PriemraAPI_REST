package com.example.priemraapi_rest.controller;

import com.example.priemraapi_rest.model.Constructor;
import com.example.priemraapi_rest.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Constructor> getAllConstructors(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection
    ) {
        return constructorService.getAllConstructorsPaged(page, size, sortBy, sortDirection).getContent();
    }

    @GetMapping("/constructors/{code}")
    public ResponseEntity<Constructor> getByCode(String code) {
        return this.constructorService.findByNameIgnoreCase(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
