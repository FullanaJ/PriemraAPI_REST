package com.example.priemraapi_rest.service;

import com.example.priemraapi_rest.model.Driver;
import com.example.priemraapi_rest.model.Race;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RaceService {
    Optional<Race> findByNameIgnoreCase(String name);

    Page<Race> getAllRacesPaged(int pageNo, int pageSize, String sortBy, String sortDirection);

}
