package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Constructor;
import com.example.priemraapi_rest.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ConstructorService {

    Optional<Constructor> findByNameIgnoreCase(String name);
    List<Constructor> getAllConstructors();

}
