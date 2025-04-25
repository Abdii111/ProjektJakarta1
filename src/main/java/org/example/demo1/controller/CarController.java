package org.example.demo1.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.demo1.dto.CarDTO;
import org.example.demo1.dto.CreateCarDTO;
import org.example.demo1.dto.UpdateCarDTO;
import org.example.demo1.mapper.CarMapper;
import org.example.demo1.Service.CarService;

import java.util.List;

@Path("/cars")  // bas-URL för alla metoder i denna klass
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarController {

    @Inject
    CarService carService;

    @POST
    public Response createCar(@Valid CreateCarDTO createCarDTO) {
        CarDTO createdCar = carService.createCar(createCarDTO);
        return Response.status(Response.Status.CREATED).entity(createdCar).build();
    }

    @GET
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GET
    @Path("/{id}")
    public CarDTO getCarById(@PathParam("id") Long id) {
        return carService.getCarById(id);
    }

    @PUT
    @Path("/{id}")
    public CarDTO updateCar(@PathParam("id") Long id, UpdateCarDTO dto) {
        return carService.updateCar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCar(@PathParam("id") Long id) {
        carService.deleteCar(id);
        return Response.noContent().build();
    }
}
