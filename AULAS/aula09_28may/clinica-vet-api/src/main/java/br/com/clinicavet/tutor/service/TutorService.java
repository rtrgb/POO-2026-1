package br.com.clinicavet.tutor.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.clinicavet.tutor.Tutor;
import br.com.clinicavet.tutor.dto.TutorRequestDTO;
import br.com.clinicavet.tutor.dto.TutorResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TutorService {

    public List<TutorResponseDTO> listarTodos() {
        return Tutor.<Tutor>listAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TutorResponseDTO buscarPorId(Long id) {
        Tutor tutor = Tutor.findById(id);
        if (tutor == null) {
            throw new NotFoundException("Tutor não encontrado com id: " + id);
        }
        return toResponse(tutor);
    }

    @Transactional
    public TutorResponseDTO criar(TutorRequestDTO dto) {
        if (Tutor.existsByCpf(dto.cpf)) {
            throw new WebApplicationException("CPF já cadastrado", Response.Status.CONFLICT);
        }
        if (Tutor.existsByEmail(dto.email)) {
            throw new WebApplicationException("Email já cadastrado", Response.Status.CONFLICT);
        }

        Tutor tutor = new Tutor();
        tutor.nome = dto.nome;
        tutor.dataNascimento = dto.dataNascimento;
        tutor.cpf = dto.cpf;
        tutor.rg = dto.rg;
        tutor.email = dto.email;
        tutor.telefone = dto.telefone;
        tutor.persist();

        return toResponse(tutor);
    }

    @Transactional
    public TutorResponseDTO atualizar(Long id, TutorRequestDTO dto) {
        Tutor tutor = Tutor.findById(id);
        if (tutor == null) {
            throw new NotFoundException("Tutor não encontrado com id: " + id);
        }

        tutor.nome = dto.nome;
        tutor.dataNascimento = dto.dataNascimento;
        tutor.cpf = dto.cpf;
        tutor.rg = dto.rg;
        tutor.email = dto.email;
        tutor.telefone = dto.telefone;

        return toResponse(tutor);
    }

    @Transactional
    public void deletar(Long id) {
        Tutor tutor = Tutor.findById(id);
        if (tutor == null) {
            throw new NotFoundException("Tutor não encontrado com id: " + id);
        }
        tutor.delete();
    }

    private TutorResponseDTO toResponse(Tutor tutor) {
        TutorResponseDTO dto = new TutorResponseDTO();
        dto.id = tutor.id;
        dto.nome = tutor.nome;
        dto.dataNascimento = tutor.dataNascimento;
        dto.cpf = tutor.cpf;
        dto.rg = tutor.rg;
        dto.email = tutor.email;
        dto.telefone = tutor.telefone;
        dto.dataCriacao = tutor.dataCriacao;
        return dto;
    }
}