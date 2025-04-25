
import org.example.demo1.Service.CarServiceImpl;
import org.example.demo1.dto.CreateCarDTO;
import org.example.demo1.entity.Car;
import org.example.demo1.exceptions.ResourceNotFoundException;
import org.example.demo1.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Starta mockning
    }

    @Test
    void getCarById_shouldThrowIfNotFound() {
        // Arrange
        when(carRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        Exception ex = assertThrows(ResourceNotFoundException.class, () -> carService.getCarById(99L));
        assertEquals("Car with id 99 not found", ex.getMessage()); // måste matcha exakta texten i din Service
    }

    @Test
    void deleteCar_shouldCallDelete() {
        Car car = new Car();
        car.setId(1L);
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        carService.deleteCar(1L);

        verify(carRepository).delete(car);
    }
}
