package org.example.demo1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record UpdateCarDTO(
        @NotBlank(message = "Car name cannot be empty")
        String carName,

        String description,

        @PastOrPresent(message = "Manufacture date cannot be in the future")
        LocalDate manufactureDate,

        @NotBlank(message = "Car make is required")
        String make,

        @Positive(message = "Year must be positive")
        int year
) {
}
