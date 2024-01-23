package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Circuit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CircuitService {

    Optional<Circuit> findByNameIgnoreCase(String code);
    List<Circuit> getAllCircuits();
}
