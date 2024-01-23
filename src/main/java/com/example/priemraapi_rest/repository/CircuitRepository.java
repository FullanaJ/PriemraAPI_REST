package com.example.priemraapi_rest.repository;

import com.example.priemraapi_rest.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    Optional<Circuit> findByNameIgnoreCase(String code);
}
