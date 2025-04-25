package org.example.demo1.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(indexes = {
        @Index(name = "idx_car_make", columnList = "make"),
        @Index(name = "idx_car_year", columnList = "year")
})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Car name cannot be empty")
    @Size(max = 100, message = "Car name cannot exceed 100 characters")
    private String name;

    @Column(name = "description", length = 500)
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @Column(name = "manufacture_date", nullable = false)
    @PastOrPresent(message = "Manufacture date cannot be in the future")
    private LocalDate manufactureDate;

    @Column(name = "make", nullable = false, length = 50)
    @NotBlank(message = "Car make is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]+$", message = "Make must start with capital letter and contain only letters")
    private String make;

    @Column(name = "year", nullable = false)
    @Min(value = 1900, message = "Year must be 1900 or later")
    @Max(value = 2100, message = "Year must be 2100 or earlier")
    private int year;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}