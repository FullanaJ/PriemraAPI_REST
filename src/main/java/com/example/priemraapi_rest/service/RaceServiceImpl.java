package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Race;
import com.example.priemraapi_rest.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RaceServiceImpl implements RaceService{

    private final RaceRepository raceRepository;
    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public Optional<Race> findByNameIgnoreCase(String code) {
        return raceRepository.findByNameIgnoreCase(code);
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

}
