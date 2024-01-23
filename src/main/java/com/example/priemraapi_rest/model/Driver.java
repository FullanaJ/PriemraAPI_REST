package com.example.priemraapi_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    @Column(unique = true)
    private String code;
    private String forename;
    private String surname;
    @JsonProperty("dateOfBirth")
    private LocalDate dob;
    private String nationality;
    private String url;
    @ManyToOne
    @JoinColumn(name = "constructorid")
    private Constructor constructor;
    @ManyToMany
    @JoinTable(name = "results",
    joinColumns = @JoinColumn (name = "driverid"),
    inverseJoinColumns = @JoinColumn(name = "raceid"))
    private Set<Race> races;
}
