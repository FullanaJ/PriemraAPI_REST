package com.example.priemraapi_rest.repository;

import com.example.priemraapi_rest.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor,Long> {

    Optional<Constructor> findByNameIgnoreCase(String name);
}
