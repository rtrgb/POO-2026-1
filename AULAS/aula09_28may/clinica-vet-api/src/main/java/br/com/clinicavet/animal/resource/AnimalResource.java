package br.com.clinicavet.animal.resource;

import java.util.List;

import br.com.clinicavet.animal.dto.AnimalRequestDTO;
import br.com.clinicavet.animal.dto.AnimalResponseDTO;
import br.com.clinicavet.animal.service.AnimalService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/animais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @GET
    public List<AnimalResponseDTO> listarTodos() {
        return animalService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public AnimalResponseDTO buscarPorId(@PathParam("id") Long id) {
        return animalService.buscarPorId(id);
    }

    @GET
    @Path("/tutor/{tutorId}")
    public List<AnimalResponseDTO> listarPorTutor(@PathParam("tutorId") Long tutorId) {
        return animalService.listarPorTutor(tutorId);
    }

    @POST
    public Response criar(@Valid AnimalRequestDTO dto) {
        AnimalResponseDTO response = animalService.criar(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @PUT
    @Path("/{id}")
    public AnimalResponseDTO atualizar(@PathParam("id") Long id, @Valid AnimalRequestDTO dto) {
        return animalService.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        animalService.deletar(id);
        return Response.noContent().build();
    }
}