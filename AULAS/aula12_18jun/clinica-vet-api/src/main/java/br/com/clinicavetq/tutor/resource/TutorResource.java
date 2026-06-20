package br.com.clinicavetq.tutor.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import br.com.clinicavetq.animal.dto.AnimalResponseDTO;
import br.com.clinicavetq.tutor.dto.TutorPatchDTO;
import br.com.clinicavetq.tutor.dto.TutorRequestDTO;
import br.com.clinicavetq.tutor.dto.TutorResponseDTO;
import br.com.clinicavetq.tutor.service.TutorService;

@Path("/tutores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TutorResource {

    @Inject
    TutorService tutorService;

    @POST
    public Response cadastrar(@Valid TutorRequestDTO dto) {

        TutorResponseDTO tutor = tutorService.cadastrar(dto);

        return Response
                .status(Response.Status.CREATED)
                .entity(tutor)
                .build();
    }

    @GET
    public List<TutorResponseDTO> listar() {
        return tutorService.listar();
    }

    @GET
    @Path("/{id}")
    public TutorResponseDTO buscarPorId(@PathParam("id") Long id) {
        return tutorService.buscarPorId(id);
    }

    @PUT
    @Path("/{id}")
    public TutorResponseDTO atualizar(
            @PathParam("id") Long id,
            @Valid TutorRequestDTO dto) {

        return tutorService.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") Long id) {

        tutorService.remover(id);

        return Response.noContent().build();
    }

    @GET
    @Path("/{id}/animais")
    public List<AnimalResponseDTO> listarAnimais(
            @PathParam("id") Long id) {

        return tutorService.listarAnimais(id);
    }
    
    @PATCH
    @Path("/{id}")
    public TutorResponseDTO atualizarParcial(
            @PathParam("id") Long id,
            TutorPatchDTO dto) {

        return tutorService.atualizarParcial(id, dto);
    }
    

    @PATCH
    @Path("/{idTutor}/animais/{idAnimal}")
    public TutorResponseDTO adicionarAnimal(
            @PathParam("idTutor") Long idTutor,
            @PathParam("idAnimal") Long idAnimal) {

        return tutorService.adicionarAnimal(idTutor, idAnimal);
    }

    @DELETE
    @Path("/{idTutor}/animais/{idAnimal}")
    public Response removerAnimal(
            @PathParam("idTutor") Long idTutor,
            @PathParam("idAnimal") Long idAnimal) {

        tutorService.removerAnimal(idTutor, idAnimal);

        return Response.noContent().build();
    }
}
