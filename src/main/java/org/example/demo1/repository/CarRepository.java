package org.example.demo1.repository;

import org.example.demo1.entity.Car;

import jakarta.data.page.PageRequest;
import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Optional<Car> findById(Long id);
    List<Car> findAll();
    List<Car> findByMake(String make);
    void save(Car car);
    void delete(Car car);
}
