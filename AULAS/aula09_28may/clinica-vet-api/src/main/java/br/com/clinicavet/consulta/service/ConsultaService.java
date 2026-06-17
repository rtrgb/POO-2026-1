package br.com.clinicavet.consulta.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.clinicavet.animal.Animal;
import br.com.clinicavet.consulta.Consulta;
import br.com.clinicavet.consulta.dto.ConsultaAgendamentoDTO;
import br.com.clinicavet.consulta.dto.ConsultaResponseDTO;
import br.com.clinicavet.shared.enums.StatusConsulta;
import br.com.clinicavet.veterinario.Veterinario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ConsultaService {

    public List<ConsultaResponseDTO> listarTodos() {
        return Consulta.<Consulta>listAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ConsultaResponseDTO buscarPorId(Long id) {
        Consulta consulta = Consulta.findById(id);
        if (consulta == null) {
            throw new NotFoundException("Consulta não encontrada com id: " + id);
        }
        return toResponse(consulta);
    }

    public List<ConsultaResponseDTO> listarPorStatus(StatusConsulta status) {
        return Consulta.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<ConsultaResponseDTO> listarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return Consulta.findByPeriodo(inicio, fim)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ConsultaResponseDTO agendar(ConsultaAgendamentoDTO dto) {
        Animal animal = Animal.findById(dto.animalId);
        if (animal == null) {
            throw new NotFoundException("Animal não encontrado com id: " + dto.animalId);
        }

        Veterinario veterinario = Veterinario.findById(dto.veterinarioId);
        if (veterinario == null) {
            throw new NotFoundException("Veterinário não encontrado com id: " + dto.veterinarioId);
        }

        Consulta consulta = new Consulta();
        consulta.animal = animal;
        consulta.veterinario = veterinario;
        consulta.dataHora = dto.dataHora;
        consulta.status = StatusConsulta.AGENDADA;
        consulta.observacoes = dto.observacoes;
        consulta.persist();

        return toResponse(consulta);
    }

    @Transactional
    public ConsultaResponseDTO remarcar(Long id, LocalDateTime novaDataHora) {
        Consulta consulta = Consulta.findById(id);
        if (consulta == null) {
            throw new NotFoundException("Consulta não encontrada com id: " + id);
        }
        if (consulta.status == StatusConsulta.CANCELADA) {
            throw new WebApplicationException("Consulta cancelada não pode ser remarcada", Response.Status.BAD_REQUEST);
        }

        consulta.dataHora = novaDataHora;
        consulta.status = StatusConsulta.AGENDADA;
        return toResponse(consulta);
    }

    @Transactional
    public ConsultaResponseDTO cancelar(Long id) {
        Consulta consulta = Consulta.findById(id);
        if (consulta == null) {
            throw new NotFoundException("Consulta não encontrada com id: " + id);
        }
        if (consulta.status == StatusConsulta.CANCELADA) {
            throw new WebApplicationException("Consulta já está cancelada", Response.Status.BAD_REQUEST);
        }

        consulta.status = StatusConsulta.CANCELADA;
        return toResponse(consulta);
    }

    @Transactional
    public ConsultaResponseDTO realizar(Long id) {
        Consulta consulta = Consulta.findById(id);
        if (consulta == null) {
            throw new NotFoundException("Consulta não encontrada com id: " + id);
        }
        if (consulta.status == StatusConsulta.CANCELADA) {
            throw new WebApplicationException("Consulta cancelada não pode ser realizada", Response.Status.BAD_REQUEST);
        }

        consulta.status = StatusConsulta.REALIZADA;
        return toResponse(consulta);
    }

    @Transactional
    public void deletar(Long id) {
        Consulta consulta = Consulta.findById(id);
        if (consulta == null) {
            throw new NotFoundException("Consulta não encontrada com id: " + id);
        }
        consulta.delete();
    }

    private ConsultaResponseDTO toResponse(Consulta consulta) {
        ConsultaResponseDTO dto = new ConsultaResponseDTO();
        dto.id = consulta.id;
        dto.animalId = consulta.animal.id;
        dto.animalNome = consulta.animal.nome;
        dto.veterinarioId = consulta.veterinario.id;
        dto.veterinarioNome = consulta.veterinario.nome;
        dto.dataHora = consulta.dataHora;
        dto.status = consulta.status;
        dto.observacoes = consulta.observacoes;
        dto.dataCriacao = consulta.dataCriacao;
        return dto;
    }
}