package br.com.clinicavet.veterinario.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.clinicavet.veterinario.Veterinario;
import br.com.clinicavet.veterinario.dto.VeterinarioRequestDTO;
import br.com.clinicavet.veterinario.dto.VeterinarioResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class VeterinarioService {

    public List<VeterinarioResponseDTO> listarTodos() {
        return Veterinario.<Veterinario>listAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public VeterinarioResponseDTO buscarPorId(Long id) {
        Veterinario vet = Veterinario.findById(id);
        if (vet == null) {
            throw new NotFoundException("Veterinário não encontrado com id: " + id);
        }
        return toResponse(vet);
    }

    @Transactional
    public VeterinarioResponseDTO criar(VeterinarioRequestDTO dto) {
        if (Veterinario.existsByCrmv(dto.crmv)) {
            throw new WebApplicationException("CRMV já cadastrado", Response.Status.CONFLICT);
        }
        if (Veterinario.existsByEmail(dto.email)) {
            throw new WebApplicationException("Email já cadastrado", Response.Status.CONFLICT);
        }

        Veterinario vet = new Veterinario();
        vet.nome = dto.nome;
        vet.crmv = dto.crmv;
        vet.especialidade = dto.especialidade;
        vet.telefone = dto.telefone;
        vet.email = dto.email;
        vet.persist();

        return toResponse(vet);
    }

    @Transactional
    public VeterinarioResponseDTO atualizar(Long id, VeterinarioRequestDTO dto) {
        Veterinario vet = Veterinario.findById(id);
        if (vet == null) {
            throw new NotFoundException("Veterinário não encontrado com id: " + id);
        }

        vet.nome = dto.nome;
        vet.crmv = dto.crmv;
        vet.especialidade = dto.especialidade;
        vet.telefone = dto.telefone;
        vet.email = dto.email;

        return toResponse(vet);
    }

    @Transactional
    public void deletar(Long id) {
        Veterinario vet = Veterinario.findById(id);
        if (vet == null) {
            throw new NotFoundException("Veterinário não encontrado com id: " + id);
        }
        vet.delete();
    }

    private VeterinarioResponseDTO toResponse(Veterinario vet) {
        VeterinarioResponseDTO dto = new VeterinarioResponseDTO();
        dto.id = vet.id;
        dto.nome = vet.nome;
        dto.crmv = vet.crmv;
        dto.especialidade = vet.especialidade;
        dto.telefone = vet.telefone;
        dto.email = vet.email;
        return dto;
    }
}