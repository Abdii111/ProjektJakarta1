package org.example.demo1.mapper;

import org.example.demo1.dto.CarDTO;
import org.example.demo1.dto.CreateCarDTO;
import org.example.demo1.dto.UpdateCarDTO;
import org.example.demo1.entity.Car;


public class CarMapper {

    public static CarDTO toCarDTO(Car car) {
        return new CarDTO(
                car.getModel(),
                car.getMake(),
                car.getYear(),
                car.getDescription()

        );
    }

}
