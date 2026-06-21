package br.com.poo.resource;

import java.util.List;
import java.util.stream.Collectors;

import br.com.poo.dto.PlanoRequestDTO;
import br.com.poo.dto.PlanoResponseDTO;
import br.com.poo.model.Plano;
import br.com.poo.service.PlanoService;
import jakarta.inject.Inject;
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

@Path("/planos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PlanoResource {
    @Inject
    PlanoService planoService;

    @GET
    public List<PlanoResponseDTO> listarTodos() {
        List<Plano> planos = planoService.listarTodos();
        return planos.stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Plano plano = planoService.buscarPorId(id);
        if (plano == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(converterParaResponse(plano)).build();

    }

    @POST
    public Response criar(PlanoRequestDTO dto) {
        Plano plano = new Plano();
        plano.setNome(dto.getNome());
        plano.setDescricao(dto.getDescricao());
        plano.setValor(dto.getValor());
        plano.setDuracao(dto.getDuracao());

        Plano planoCriado = planoService.criar(plano);
        return Response.status(Response.Status.CREATED)
                .entity(converterParaResponse(planoCriado))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, PlanoRequestDTO dto) {
        Plano dadosNovos = new Plano();
        dadosNovos.setNome(dto.getNome());
        dadosNovos.setDescricao(dto.getDescricao());
        dadosNovos.setValor(dto.getValor());
        dadosNovos.setDuracao(dto.getDuracao());

        Plano planoAtualizado = planoService.atualizar(id, dadosNovos);
        if (planoAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(converterParaResponse(planoAtualizado)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = planoService.deletar(id);
        if (!removido) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

    private PlanoResponseDTO converterParaResponse(Plano plano) {
        PlanoResponseDTO dto = new PlanoResponseDTO();
        dto.setId(plano.getId());
        dto.setNome(plano.getNome());
        dto.setDescricao(plano.getDescricao());
        dto.setValor(plano.getValor());
        dto.setDuracao(plano.getDuracao());
        return dto;
    }
}
