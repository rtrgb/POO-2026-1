package br.com.clinicavet.veterinario.resource;

import java.util.List;

import br.com.clinicavet.veterinario.dto.VeterinarioRequestDTO;
import br.com.clinicavet.veterinario.dto.VeterinarioResponseDTO;
import br.com.clinicavet.veterinario.service.VeterinarioService;
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

@Path("/veterinarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeterinarioResource {

    @Inject
    VeterinarioService veterinarioService;

    @GET
    public List<VeterinarioResponseDTO> listarTodos() {
        return veterinarioService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public VeterinarioResponseDTO buscarPorId(@PathParam("id") Long id) {
        return veterinarioService.buscarPorId(id);
    }

    @POST
    public Response criar(@Valid VeterinarioRequestDTO dto) {
        VeterinarioResponseDTO response = veterinarioService.criar(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @PUT
    @Path("/{id}")
    public VeterinarioResponseDTO atualizar(@PathParam("id") Long id, @Valid VeterinarioRequestDTO dto) {
        return veterinarioService.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        veterinarioService.deletar(id);
        return Response.noContent().build();
    }
}