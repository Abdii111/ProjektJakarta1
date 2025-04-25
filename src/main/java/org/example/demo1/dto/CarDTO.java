package org.example.demo1.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CarDTO {
    private Long carId;
    private String carName;
    private String make;
    private int year;
    private String description;
    private LocalDate manufactureDate;
}
