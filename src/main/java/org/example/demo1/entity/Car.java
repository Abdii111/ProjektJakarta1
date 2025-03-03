package org.example.demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car name is required")
    private String name;

    @Size(max = 500, message = "Description cant exceed 500 characters")
    private String description;

    @PastOrPresent(message = "Manufactor date must be in the past or present")
    private LocalDate manufactureDate;

    @NotBlank(message = "Car make is required")
    private String make;

    @Min(value = 1886, message = "Year must be a valid manufacturing year (1886 or later)")
    @Max(value = 2025, message = "Year cannot be in the future")
    private int year;

    // Constructors
    public Car() {}

    public Car (String name, String description, LocalDate manufactureDate, String make, int year) {
        this.name = name;
        this.description = description;
        this.manufactureDate = manufactureDate;
        this.make = make;
        this.year = year;
    }

    // Getters and Setters
    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public LocalDate getManufactureDate() { return manufactureDate;}
    public void setManufactureDate(LocalDate manufactureDate) {this.manufactureDate = manufactureDate;}

    public String getMake() { return make;}
    public void setMake(String make) { this.make = make;}

    public int getYear() { return year;}
    public void setYear(int year) { this.year = year;}


}
