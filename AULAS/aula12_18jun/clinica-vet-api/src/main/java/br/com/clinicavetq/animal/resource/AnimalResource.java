package br.com.clinicavetq.animal.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import br.com.clinicavetq.animal.dto.AnimalPatchDTO;
import br.com.clinicavetq.animal.dto.AnimalRequestDTO;
import br.com.clinicavetq.animal.dto.AnimalResponseDTO;
import br.com.clinicavetq.animal.service.AnimalService;

@Path("/animais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @POST
    public Response cadastrar(@Valid AnimalRequestDTO dto) {

        AnimalResponseDTO animal = animalService.cadastrar(dto);
        return Response
                .status(Response.Status.CREATED)
                .entity(animal)
                .build();
    }

    @GET
    public List<AnimalResponseDTO> listar() {
        return animalService.listar();
    }

    @GET
    @Path("/{id}")
    public AnimalResponseDTO buscarPorId(
            @PathParam("id") Long id) {
        return animalService.buscarPorId(id);
    }

    @PUT
    @Path("/{id}")
    public AnimalResponseDTO atualizar(
            @PathParam("id") Long id,
            @Valid AnimalRequestDTO dto) {
        return animalService.atualizar(id, dto);
    }

    @PATCH
    @Path("/{id}")
    public AnimalResponseDTO atualizarParcial(
            @PathParam("id") Long id,
            AnimalPatchDTO dto) {

        return animalService.atualizarParcial(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response remover(
            @PathParam("id") Long id) {

        animalService.remover(id);

        return Response.noContent().build();
    }
    
}