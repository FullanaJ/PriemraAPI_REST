package com.example.priemraapi_rest.controller;

import com.example.priemraapi_rest.model.Driver;
import com.example.priemraapi_rest.model.Race;
import com.example.priemraapi_rest.service.RaceService;
import com.example.priemraapi_rest.service.RaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceRestController {

    private final RaceService raceService;
    @Autowired
    public RaceRestController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/races")
    public ResponseEntity<List<Race>> getAllRaces() {
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/races/{code}")
    public ResponseEntity<Race> getByCode(@PathVariable String code) {
        return this.raceService.findByNameIgnoreCase(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
