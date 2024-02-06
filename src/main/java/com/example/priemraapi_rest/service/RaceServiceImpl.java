package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Race;
import com.example.priemraapi_rest.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Race> getAllRacesPaged(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return raceRepository.findAll(pageable);
    }

}
