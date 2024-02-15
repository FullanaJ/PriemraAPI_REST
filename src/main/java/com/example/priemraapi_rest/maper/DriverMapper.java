package com.example.priemraapi_rest.maper;

import com.example.priemraapi_rest.DTO.DriverDTO;
import com.example.priemraapi_rest.model.Driver;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.function.Function;
@Service
public class DriverMapper implements Function<Driver, DriverDTO> {
    @Override
    public DriverDTO apply(Driver driver) {
        return new DriverDTO(
                driver.getForename() + " " + driver.getSurname(),
                driver.getDob(),
                driver.getNationality(),
                Objects.isNull(driver.getConstructor())  ? "" : driver.getConstructor().getName()
        );
    }
}
