package com.example.priemraapi_rest.repository;

import com.example.priemraapi_rest.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RaceRepository extends JpaRepository<Race,Long> {
    Optional<Race> findByNameIgnoreCase(String code);

}
