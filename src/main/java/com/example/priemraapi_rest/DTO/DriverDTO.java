package com.example.priemraapi_rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@Data
public class DriverDTO {
    private String NameAndSurname;
    private int age;
    private String nationality;
    private String constructorName;

    public DriverDTO(String nameAndSurname, LocalDate dob, String nationality, String constructorName) {
        NameAndSurname = nameAndSurname;
        this.age =  Period.between(dob,LocalDate.now()).getYears();
        this.nationality = nationality;
        this.constructorName = constructorName;
    }
}
