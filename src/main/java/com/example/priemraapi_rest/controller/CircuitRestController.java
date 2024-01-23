package com.example.priemraapi_rest.controller;

import com.example.priemraapi_rest.model.Circuit;
import com.example.priemraapi_rest.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CircuitRestController {

    private final CircuitService circuitService;
    @Autowired
    public CircuitRestController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }
    @GetMapping("/circuits/{code}")
    public ResponseEntity<Circuit> findCircuitByIdIgnoreCase(String code){
        return circuitService.findByNameIgnoreCase(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/circuits")
    public ResponseEntity<List<Circuit>> getAllCircuits(){
        return ResponseEntity.ok(circuitService.getAllCircuits());
    }
}
