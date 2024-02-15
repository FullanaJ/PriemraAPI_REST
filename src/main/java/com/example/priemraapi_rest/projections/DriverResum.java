package com.example.priemraapi_rest.projections;

public interface DriverResum {

    String getForename();
    String getSurname();
    String getConstructorName();

    String getNationality();

    ConstructorResum getConstructor();

}
