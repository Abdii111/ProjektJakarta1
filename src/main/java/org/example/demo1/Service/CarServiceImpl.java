package org.example.demo1.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.demo1.dto.*;
import org.example.demo1.entity.Car;
import org.example.demo1.exceptions.ResourceNotFoundException;
import org.example.demo1.mapper.CarMapper;
import org.example.demo1.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CarServiceImpl implements CarService {

    @Inject
    private CarRepository carRepository;

    @Override
    public CarDTO createCar(CreateCarDTO dto) {
        // Omvandla CreateCarDTO till Car
        Car car = CarMapper.toCar(dto);
        carRepository.save(car);
        return CarMapper.toCarDTO(car);
    }

    @Override
    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car with id " + id + " not found"));
        return CarMapper.toCarDTO(car);
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(CarMapper::toCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO updateCar(Long id, UpdateCarDTO dto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found"));

        CarMapper.updateCarFromDto(dto, car);
        carRepository.save(car);

        return CarMapper.toCarDTO(car);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car with id " + id + " not found"));
        carRepository.delete(car);
    }
}
