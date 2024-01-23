package com.example.priemraapi_rest.repository;

import com.example.priemraapi_rest.DTO.DriverDTO;
import com.example.priemraapi_rest.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByCodeIgnoreCase(String code);
    @Query("""
            SELECT  new com.example.priemraapi_rest.DTO.DriverDTO(concat(e.forename,' ',e.surname), (e.dob) , e.nationality,e.constructor.name) 
            FROM Driver e
            """)
    List<DriverDTO> findAllDriverDTOInfo();

}
