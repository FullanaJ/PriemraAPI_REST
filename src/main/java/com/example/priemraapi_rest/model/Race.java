package com.example.priemraapi_rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "races")
@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long raceid;
    private int year;
    private int round;
    private String name;
    private LocalDate date;
    private Time time;
    private String url;
    @OneToOne
    @JoinColumn(name = "circuitid")
    private Circuit circuit;
}
