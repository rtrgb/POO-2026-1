package br.com.clinicavet.tutor.resource;

import java.util.List;

import br.com.clinicavet.tutor.dto.TutorRequestDTO;
import br.com.clinicavet.tutor.dto.TutorResponseDTO;
import br.com.clinicavet.tutor.service.TutorService;
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

@Path("/tutores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TutorResource {

    @Inject
    TutorService tutorService;

    @GET
    public List<TutorResponseDTO> listarTodos() {
        return tutorService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public TutorResponseDTO buscarPorId(@PathParam("id") Long id) {
        return tutorService.buscarPorId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(TutorRequestDTO dto) {
        TutorResponseDTO response = tutorService.criar(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @PUT
    @Path("/{id}")
    public TutorResponseDTO atualizar(@PathParam("id") Long id, @Valid TutorRequestDTO dto) {
        return tutorService.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        tutorService.deletar(id);
        return Response.noContent().build();
    }
}