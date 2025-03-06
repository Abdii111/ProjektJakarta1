package org.example.demo1.dto;

import jakarta.validation.constraints.Size;

public class UpdateCarDTO {
    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;
}
