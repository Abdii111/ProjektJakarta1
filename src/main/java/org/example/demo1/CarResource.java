package org.example.demo1;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.demo1.dto.CarDTO;
import org.example.demo1.dto.CreateCarDTO;
import org.example.demo1.Service.CarService;

@Path("/api/cars")
public class CarResource {

    @Inject
    CarService carService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCar(CreateCarDTO createCarDTO) {
        CarDTO carDTO = carService.createCar(createCarDTO);
        return Response.status(Response.Status.CREATED).entity(carDTO).build();
    }
}
