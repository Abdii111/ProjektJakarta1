package org.example.demo1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCarDTO {
    private String name;
    private String make;
    private int year;
    private String description;
    private LocalDate manufactureDate;
}
