package br.com.clinicavet.consulta.resource;

import java.time.LocalDateTime;
import java.util.List;

import br.com.clinicavet.consulta.dto.ConsultaAgendamentoDTO;
import br.com.clinicavet.consulta.dto.ConsultaResponseDTO;
import br.com.clinicavet.consulta.service.ConsultaService;
import br.com.clinicavet.shared.enums.StatusConsulta;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/consultas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultaResource {

    @Inject
    ConsultaService consultaService;

    @GET
    public List<ConsultaResponseDTO> listarTodos(
            @QueryParam("status") StatusConsulta status,
            @QueryParam("inicio") LocalDateTime inicio,
            @QueryParam("fim") LocalDateTime fim) {

        if (status != null) {
            return consultaService.listarPorStatus(status);
        }
        if (inicio != null && fim != null) {
            return consultaService.listarPorPeriodo(inicio, fim);
        }
        return consultaService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public ConsultaResponseDTO buscarPorId(@PathParam("id") Long id) {
        return consultaService.buscarPorId(id);
    }

    @POST
    public Response agendar(@Valid ConsultaAgendamentoDTO dto) {
        ConsultaResponseDTO response = consultaService.agendar(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @PATCH
    @Path("/{id}/cancelar")
    public ConsultaResponseDTO cancelar(@PathParam("id") Long id) {
        return consultaService.cancelar(id);
    }

    @PATCH
    @Path("/{id}/remarcar")
    public ConsultaResponseDTO remarcar(@PathParam("id") Long id, LocalDateTime novaDataHora) {
        return consultaService.remarcar(id, novaDataHora);
    }

    @PATCH
    @Path("/{id}/realizar")
    public ConsultaResponseDTO realizar(@PathParam("id") Long id) {
        return consultaService.realizar(id);
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        consultaService.deletar(id);
        return Response.noContent().build();
    }
}