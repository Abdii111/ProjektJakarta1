package org.example.demo1.Service;

import jakarta.validation.Valid;
import org.example.demo1.dto.CarDTO;
import org.example.demo1.dto.CreateCarDTO;
import org.example.demo1.dto.UpdateCarDTO;

import java.util.List;

public interface CarService {
    CarDTO createCar(@Valid CreateCarDTO dto); // INTE statisk
    CarDTO getCarById(Long id);
    List<CarDTO> getAllCars();
    CarDTO updateCar(Long id, UpdateCarDTO dto);
    void deleteCar(Long id);
}
