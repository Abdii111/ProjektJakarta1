package org.example.demo1.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.Year;

public class CreateCarDTO {
    @NotBlank(message = "Make is required")
    String make;

    @NotBlank(message = "Model is required")
    String model;

    @NotNull(message = "Year is required")

    @Min(value = 1886, message = "Year must be after 1885") // Första bilen uppfanns 1886
    @Max(value = 2026, message = "Year must be before 2025")
    private Integer year;

    @Size(max = 1000, message = "Description must be less than 1000 charachters")
    private String description;

    @PastOrPresent(message = "Manufacting date must be in the past present")
    private LocalDate manufactingDate;







}
