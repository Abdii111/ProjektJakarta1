package org.example.demo1.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.demo1.entity.Car;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }

    @Override
    public List<Car> findAll() {
        return entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }

    @Override
    public List<Car> findByMake(String make) {
        return entityManager.createQuery("SELECT c FROM Car c WHERE c.make = :make", Car.class)
                .setParameter("make", make)
                .getResultList();
    }

    @Override
    public void save(Car car) {
        if (car.getId() == null) {
            entityManager.persist(car);
        } else {
            entityManager.merge(car);
        }
    }

    @Override
    public void delete(Car car) {
        if (entityManager.contains(car)) {
            entityManager.remove(car);
        } else {
            entityManager.remove(entityManager.merge(car));
        }
    }
}
