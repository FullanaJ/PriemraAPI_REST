package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Circuit;
import com.example.priemraapi_rest.repository.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService{

    private final CircuitRepository circuitRepository;
    @Autowired
    public CircuitServiceImpl(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    @Override
    public Optional<Circuit> findByNameIgnoreCase(String code) {
        return circuitRepository.findByNameIgnoreCase(code);
    }

    @Override
    public List<Circuit> getAllCircuits() {
        return circuitRepository.findAll();
    }
}
