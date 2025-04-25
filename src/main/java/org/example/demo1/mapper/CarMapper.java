package org.example.demo1.mapper;

import org.example.demo1.dto.CarDTO;
import org.example.demo1.dto.CreateCarDTO;
import org.example.demo1.dto.UpdateCarDTO;
import org.example.demo1.entity.Car;


public class CarMapper {

    public static CarDTO toCarDTO(Car car) {
        if (car == null) {
            return null;
        }

        return CarDTO.builder()
                .carId(car.getId())
                .carName(car.getName())
                .make(car.getMake())
                .year(car.getYear())
                .description(car.getDescription())
                .manufactureDate(car.getManufactureDate())
                .build();

    }

    public static Car toCar(CreateCarDTO dto) {
        if (dto == null) {
            return null;
        }

        return Car.builder()
                .name(dto.getName())
                .make(dto.getMake())
                .year(dto.getYear())
                .description(dto.getDescription())
                .manufactureDate(dto.getManufactureDate())
                .build();
    }

    public static void updateCarFromDto(UpdateCarDTO dto, Car car) {
        if (dto == null || car == null) {
            return;
        }

        if (dto.carName() != null) {
            car.setName(dto.carName());
        }
        if (dto.make() != null) {
            car.setMake(dto.make());
        }
        if (dto.year() != 0) { // Eller använd Integer och kolla null
            car.setYear(dto.year());
        }
        if (dto.description() != null) {
            car.setDescription(dto.description());
        }
        if (dto.manufactureDate() != null) {
            car.setManufactureDate(dto.manufactureDate());
        }
    }


    public static Car toEntity(CreateCarDTO carDTO) {
        return null;
    }
}