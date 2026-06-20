package br.com.clinicavetq.animal.service;


import java.util.ArrayList;
import java.util.List;

import br.com.clinicavetq.animal.dto.AnimalPatchDTO;
import br.com.clinicavetq.animal.dto.AnimalRequestDTO;
import br.com.clinicavetq.animal.dto.AnimalResponseDTO;
import br.com.clinicavetq.animal.model.Animal;
import br.com.clinicavetq.tutor.dto.TutorDadosDTO;
import br.com.clinicavetq.tutor.model.Tutor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AnimalService {

    @Transactional
    public AnimalResponseDTO cadastrar(AnimalRequestDTO dto) {

        if (Animal.existsByRga(dto.rga())) {
            throw new IllegalArgumentException("Já existe um animal cadastrado com este RGA.");
        }

        Tutor tutor = Tutor.findTutorById(dto.idTutor())
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        Animal animal = new Animal();
        animal.nome = dto.nome();
        animal.raca = dto.raca();
        animal.sexo = dto.sexo();
        animal.especie = dto.especie();
        animal.dataNascimento = dto.dataNascimento();
        animal.rga = dto.rga();
        animal.castrado = dto.castrado();
        animal.corPelagem = dto.corPelagem();
        animal.porte = dto.porte();
        animal.peso = dto.peso();
        animal.observacoes = dto.observacoes();
        animal.vivo = true;
        animal.tutor = tutor;

        animal.persist();

        return montarResponse(animal);
    }

    public List<AnimalResponseDTO> listar() {

        List<Animal> animais = Animal.listAll();
        List<AnimalResponseDTO> listaDTO = new ArrayList<>();

        for (Animal animal : animais) {
            listaDTO.add(montarResponse(animal));
        }

        return listaDTO;
    }

    public AnimalResponseDTO buscarPorId(Long id) {

    	Animal animal = Animal.findAnimalById(id)
    	        .orElseThrow(() -> new NotFoundException("Animal não encontrado."));

        return montarResponse(animal);
    }

    @Transactional
    public AnimalResponseDTO atualizar(Long id, AnimalRequestDTO dto) {

    		Animal animal = Animal.findAnimalById(id)
    	        .orElseThrow(() -> new NotFoundException("Animal não encontrado."));

        Tutor tutor = Tutor.findTutorById(dto.idTutor())
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        animal.nome = dto.nome();
        animal.raca = dto.raca();
        animal.sexo = dto.sexo();
        animal.especie = dto.especie();
        animal.dataNascimento = dto.dataNascimento();
        animal.castrado = dto.castrado();
        animal.corPelagem = dto.corPelagem();
        animal.porte = dto.porte();
        animal.peso = dto.peso();
        animal.observacoes = dto.observacoes();
        animal.tutor = tutor;

        return montarResponse(animal);
    }

    @Transactional
    public void remover(Long id) {

    	Animal animal = Animal.findAnimalById(id)
    	        .orElseThrow(() -> new NotFoundException("Animal não encontrado."));

        animal.delete();
    }

    private AnimalResponseDTO montarResponse(Animal animal) {

        TutorDadosDTO tutorDTO = new TutorDadosDTO(
                animal.tutor.id,
                animal.tutor.nome,
                animal.tutor.dataNascimento,
                animal.tutor.cpf,
                animal.tutor.rg,
                animal.tutor.email,
                animal.tutor.telefone
        );

        return new AnimalResponseDTO(
                animal.id,
                animal.nome,
                animal.raca,
                animal.sexo,
                animal.especie,
                animal.dataNascimento,
                animal.rga,
                animal.vivo,
                animal.castrado,
                animal.corPelagem,
                animal.porte,
                animal.peso,
                animal.observacoes,
                tutorDTO
        );
    }

    @Transactional
    public AnimalResponseDTO atualizarParcial(Long id, AnimalPatchDTO dto) {

        Animal animal = Animal.findAnimalById(id)
                .orElseThrow(() -> new NotFoundException("Animal não encontrado."));

        if (dto.nome() != null) {
            animal.nome = dto.nome();
        }

        if (dto.raca() != null) {
            animal.raca = dto.raca();
        }

        if (dto.sexo() != null) {
            animal.sexo = dto.sexo();
        }

        if (dto.especie() != null) {
            animal.especie = dto.especie();
        }

        if (dto.dataNascimento() != null) {
            animal.dataNascimento = dto.dataNascimento();
        }

        if (dto.rga() != null) {
            if (!dto.rga().equals(animal.rga) && Animal.existsByRga(dto.rga())) {
                throw new IllegalArgumentException("Já existe um animal cadastrado com este RGA.");
            }

            animal.rga = dto.rga();
        }

        if (dto.castrado() != null) {
            animal.castrado = dto.castrado();
        }

        if (dto.corPelagem() != null) {
            animal.corPelagem = dto.corPelagem();
        }

        if (dto.porte() != null) {
            animal.porte = dto.porte();
        }

        if (dto.peso() != null) {
            animal.peso = dto.peso();
        }

        if (dto.observacoes() != null) {
            animal.observacoes = dto.observacoes();
        }

        if (dto.idTutor() != null) {
            Tutor tutor = Tutor.findTutorById(dto.idTutor())
                    .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

            animal.tutor = tutor;
        }
        return montarResponse(animal);
    }
    
}