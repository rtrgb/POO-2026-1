package br.com.clinicavet.animal.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.clinicavet.animal.Animal;
import br.com.clinicavet.animal.dto.AnimalRequestDTO;
import br.com.clinicavet.animal.dto.AnimalResponseDTO;
import br.com.clinicavet.tutor.Tutor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class AnimalService {

    public List<AnimalResponseDTO> listarTodos() {
        return Animal.<Animal>listAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AnimalResponseDTO buscarPorId(Long id) {
        Animal animal = Animal.findById(id);
        if (animal == null) {
            throw new NotFoundException("Animal não encontrado com id: " + id);
        }
        return toResponse(animal);
    }

    public List<AnimalResponseDTO> listarPorTutor(Long tutorId) {
        return Animal.findByTutor(tutorId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public AnimalResponseDTO criar(AnimalRequestDTO dto) {
        Tutor tutor = Tutor.findById(dto.tutorId);
        if (tutor == null) {
            throw new NotFoundException("Tutor não encontrado com id: " + dto.tutorId);
        }
        if (Animal.existsByRga(dto.rga)) {
            throw new WebApplicationException("RGA já cadastrado", Response.Status.CONFLICT);
        }

        Animal animal = new Animal();
        animal.nome = dto.nome;
        animal.raca = dto.raca;
        animal.sexo = dto.sexo;
        animal.especie = dto.especie;
        animal.dataNascimento = dto.dataNascimento;
        animal.rga = dto.rga;
        animal.castrado = dto.castrado;
        animal.corPelagem = dto.corPelagem;
        animal.porte = dto.porte;
        animal.peso = dto.peso;
        animal.observacoes = dto.observacoes != null ? dto.observacoes : "";
        animal.tutor = tutor;
        animal.persist();

        return toResponse(animal);
    }

    @Transactional
    public AnimalResponseDTO atualizar(Long id, AnimalRequestDTO dto) {
        Animal animal = Animal.findById(id);
        if (animal == null) {
            throw new NotFoundException("Animal não encontrado com id: " + id);
        }

        Tutor tutor = Tutor.findById(dto.tutorId);
        if (tutor == null) {
            throw new NotFoundException("Tutor não encontrado com id: " + dto.tutorId);
        }

        animal.nome = dto.nome;
        animal.raca = dto.raca;
        animal.sexo = dto.sexo;
        animal.especie = dto.especie;
        animal.dataNascimento = dto.dataNascimento;
        animal.rga = dto.rga;
        animal.castrado = dto.castrado;
        animal.corPelagem = dto.corPelagem;
        animal.porte = dto.porte;
        animal.peso = dto.peso;
        animal.observacoes = dto.observacoes;
        animal.tutor = tutor;

        return toResponse(animal);
    }

    @Transactional
    public void deletar(Long id) {
        Animal animal = Animal.findById(id);
        if (animal == null) {
            throw new NotFoundException("Animal não encontrado com id: " + id);
        }
        animal.delete();
    }

    private AnimalResponseDTO toResponse(Animal animal) {
        AnimalResponseDTO dto = new AnimalResponseDTO();
        dto.id = animal.id;
        dto.nome = animal.nome;
        dto.raca = animal.raca;
        dto.sexo = animal.sexo;
        dto.especie = animal.especie;
        dto.dataNascimento = animal.dataNascimento;
        dto.rga = animal.rga;
        dto.vivo = animal.vivo;
        dto.castrado = animal.castrado;
        dto.corPelagem = animal.corPelagem;
        dto.porte = animal.porte;
        dto.peso = animal.peso;
        dto.observacoes = animal.observacoes;
        dto.tutorId = animal.tutor.id;
        dto.tutorNome = animal.tutor.nome;
        dto.dataCriacao = animal.dataCriacao;
        return dto;
    }
}