import org.example.demo1.dto.CarDTO;
import org.example.demo1.dto.CreateCarDTO;
import org.example.demo1.dto.UpdateCarDTO;
import org.example.demo1.entity.Car;
import org.example.demo1.mapper.CarMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    @Test
    void shouldMapEntityToDtoCorrectly() {
        Car car = Car.builder()
                .id(1L)
                .name("Model S")
                .make("Tesla")
                .year(2021)
                .description("Electric car")
                .manufactureDate(LocalDate.of(2020, 1, 1))
                .build();

        CarDTO dto = CarMapper.toCarDTO(car);

        assertEquals(car.getId(), dto.getCarId());
        assertEquals(car.getName(), dto.getCarName());
        assertEquals(car.getMake(), dto.getMake());
        assertEquals(car.getYear(), dto.getYear());
        assertEquals(car.getDescription(), dto.getDescription());
        assertEquals(car.getManufactureDate(), dto.getManufactureDate());
    }

    @Test
    void shouldMapCreateDtoToEntityCorrectly() {
        // Skapa ett objekt med parameterlös konstruktor
        CreateCarDTO dto = new CreateCarDTO();

        // Sätt alla värden via setters
        dto.setName("Model X");
        dto.setMake("Tesla");
        dto.setYear(2022);
        dto.setDescription("SUV");
        dto.setManufactureDate(LocalDate.of(2021, 6, 15));

        Car car = CarMapper.toCar(dto);

        assertEquals(dto.getName(), car.getName());
        assertEquals(dto.getMake(), car.getMake());
        assertEquals(dto.getYear(), car.getYear());
        assertEquals(dto.getDescription(), car.getDescription());
        assertEquals(dto.getManufactureDate(), car.getManufactureDate());
    }


    @Test
    void shouldUpdateEntityFromDtoCorrectly() {
        Car car = new Car();

        UpdateCarDTO dto = new UpdateCarDTO(
                "Updated Model",
                "Updated desc",
                LocalDate.of(2019, 1, 1),
                "Updated Make",
                2020
        );

        CarMapper.updateCarFromDto(dto, car);

        assertEquals("Updated Model", car.getName());
        assertEquals("Updated Make", car.getMake());
        assertEquals(2020, car.getYear());
        assertEquals("Updated desc", car.getDescription());
        assertEquals(LocalDate.of(2019, 1, 1), car.getManufactureDate());
    }
}
