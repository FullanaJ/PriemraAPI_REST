package com.example.priemraapi_rest.controller;

import com.example.priemraapi_rest.model.Race;
import com.example.priemraapi_rest.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Race>> getAllRaces(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "raceid") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {
        Page<Race> list = raceService.getAllRacesPaged(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(list.getContent());
    }

    @GetMapping("/races/{code}")
    public ResponseEntity<Race> getByCode(@PathVariable String code) {
        return this.raceService.findByNameIgnoreCase(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
