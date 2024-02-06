package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Constructor;
import com.example.priemraapi_rest.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService{

    private final ConstructorRepository constructorRepository;
    @Autowired
    public ConstructorServiceImpl(ConstructorRepository constructorRepository) {
        this.constructorRepository = constructorRepository;
    }

    @Override
    public Optional<Constructor> findByNameIgnoreCase(String code) {
        return constructorRepository.findByNameIgnoreCase(code);
    }

    @Override
    public Page<Constructor> getAllConstructorsPaged(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return constructorRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }

}
