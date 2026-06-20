package br.com.clinicavetq.veterinario.resource;

import java.util.List;

import br.com.clinicavetq.veterinario.dto.VeterinarioPatchDTO;
import br.com.clinicavetq.veterinario.dto.VeterinarioRequestDTO;
import br.com.clinicavetq.veterinario.dto.VeterinarioResponseDTO;
import br.com.clinicavetq.veterinario.service.VeterinarioService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/veterinarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeterinarioResource {

    @Inject
    VeterinarioService veterinarioService;

    @POST
    public Response cadastrar(
            @Valid VeterinarioRequestDTO dto) {

        VeterinarioResponseDTO response =
                veterinarioService.cadastrar(dto);

        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @GET
    public List<VeterinarioResponseDTO> listar() {
        return veterinarioService.listar();
    }

    @GET
    @Path("/{id}")
    public VeterinarioResponseDTO buscarPorId(
            @PathParam("id") Long id) {

        return veterinarioService.buscarPorId(id);
    }
    
    @PATCH
    @Path("/{id}")
    public VeterinarioResponseDTO atualizarParcial(
            @PathParam("id") Long id,
            VeterinarioPatchDTO dto) {

        return veterinarioService.atualizarParcial(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response remover(
            @PathParam("id") Long id) {

        veterinarioService.remover(id);

        return Response.noContent().build();
    }
    
}