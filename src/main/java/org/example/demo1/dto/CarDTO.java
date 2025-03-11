package org.example.demo1.dto;

import java.time.LocalDate;

public class CarDTO {
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private String description;
    private LocalDate manufactureDate;

    // Konstruktor för CarDTO
    public CarDTO(String model, String make, Integer year, String description) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.description = description;
    }

    // Getters och Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
