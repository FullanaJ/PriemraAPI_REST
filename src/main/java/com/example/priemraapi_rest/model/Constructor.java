package com.example.priemraapi_rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "constructors")
public class Constructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long constructorid;
    private String constructorref;
    private String name;
    private String nationality;
    private String url;
    @OneToMany(mappedBy = "constructor",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties
    private Set<Driver> driver;

}
