package br.com.clinicavetq.tutor.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import br.com.clinicavetq.animal.dto.AnimalResponseDTO;
import br.com.clinicavetq.animal.dto.AnimalDadosDTO;
import br.com.clinicavetq.animal.model.Animal;
import br.com.clinicavetq.tutor.dto.TutorRequestDTO;
import br.com.clinicavetq.tutor.dto.TutorResponseDTO;
import br.com.clinicavetq.tutor.dto.TutorDadosDTO;
import br.com.clinicavetq.tutor.dto.TutorPatchDTO;
import br.com.clinicavetq.tutor.model.Tutor;

@ApplicationScoped
public class TutorService {

    @Transactional
    public TutorResponseDTO cadastrar(TutorRequestDTO dto) {

        if (Tutor.existsByCpf(dto.cpf())) {
            throw new IllegalArgumentException("Já existe um tutor cadastrado com este CPF.");
        }

        if (Tutor.existsByRg(dto.rg())) {
            throw new IllegalArgumentException("Já existe um tutor cadastrado com este RG.");
        }

        if (Tutor.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Já existe um tutor cadastrado com este e-mail.");
        }

        if (Tutor.existsByTelefone(dto.telefone())) {
            throw new IllegalArgumentException("Já existe um tutor cadastrado com este telefone.");
        }

        Tutor tutor = new Tutor();
        tutor.nome = dto.nome();
        tutor.dataNascimento = dto.dataNascimento();
        tutor.cpf = dto.cpf();
        tutor.rg = dto.rg();
        tutor.email = dto.email();
        tutor.telefone = dto.telefone();

        tutor.persist();

        return montarResponse(tutor);
    }

    public List<TutorResponseDTO> listar() {

        List<Tutor> tutores = Tutor.listAll();
        List<TutorResponseDTO> listaDTO = new ArrayList<>();

        for (Tutor tutor : tutores) {
            listaDTO.add(montarResponse(tutor));
        }

        return listaDTO;
    }

    public TutorResponseDTO buscarPorId(Long id) {

        Tutor tutor = Tutor.findTutorById(id)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        return montarResponse(tutor);
    }

    @Transactional
    public TutorResponseDTO atualizar(Long id, TutorRequestDTO dto) {

        Tutor tutor = Tutor.findTutorById(id)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        tutor.nome = dto.nome();
        tutor.dataNascimento = dto.dataNascimento();
        tutor.email = dto.email();
        tutor.telefone = dto.telefone();

        return montarResponse(tutor);
    }

    @Transactional
    public void remover(Long id) {

        Tutor tutor = Tutor.findTutorById(id)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        tutor.delete();
    }

    public List<AnimalResponseDTO> listarAnimais(Long idTutor) {

        Tutor.<Tutor>findByIdOptional(idTutor)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        List<Animal> animais = Animal.findByTutor(idTutor);
        List<AnimalResponseDTO> listaDTO = new ArrayList<>();

        for (Animal animal : animais) {
            listaDTO.add(montarAnimalResponse(animal));
        }

        return listaDTO;
    }

    @Transactional
    public TutorResponseDTO adicionarAnimal(Long idTutor, Long idAnimal) {

        Tutor tutor = Tutor.<Tutor>findByIdOptional(idTutor)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        Animal animal = Animal.findAnimalById(idAnimal)
                .orElseThrow(() -> new NotFoundException("Animal não encontrado."));

        animal.tutor = tutor;

        return montarResponse(tutor);
    }

    @Transactional
    public void removerAnimal(Long idTutor, Long idAnimal) {

        Tutor.<Tutor>findByIdOptional(idTutor)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        Animal animal = Animal.findAnimalById(idAnimal)
                .orElseThrow(() -> new NotFoundException("Animal não encontrado."));

        if (!animal.tutor.id.equals(idTutor)) {
            throw new IllegalArgumentException("Este animal não pertence ao tutor informado.");
        }

        animal.delete();
    }

    private TutorResponseDTO montarResponse(Tutor tutor) {

        List<Animal> animais = Animal.findByTutor(tutor.id);
        List<AnimalDadosDTO> animaisDTO = new ArrayList<>();

        for (Animal animal : animais) {
            AnimalDadosDTO animalDTO = new AnimalDadosDTO(
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
                    animal.observacoes);
            animaisDTO.add(animalDTO);
        }
        return new TutorResponseDTO(
                tutor.id,
                tutor.nome,
                tutor.cpf,
                tutor.email,
                tutor.telefone,
                animaisDTO);
    }

    private AnimalResponseDTO montarAnimalResponse(Animal animal) {

        TutorDadosDTO tutorDTO = new TutorDadosDTO(
                animal.tutor.id,
                animal.tutor.nome,
                animal.tutor.dataNascimento,
                animal.tutor.cpf,
                animal.tutor.rg,
                animal.tutor.email,
                animal.tutor.telefone);
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
                tutorDTO);
    }

    @Transactional
    public TutorResponseDTO atualizarParcial(Long id, TutorPatchDTO dto) {

        Tutor tutor = Tutor.findTutorById(id)
                .orElseThrow(() -> new NotFoundException("Tutor não encontrado."));

        if (dto.nome() != null) {
            tutor.nome = dto.nome();
        }

        if (dto.dataNascimento() != null) {
            tutor.dataNascimento = dto.dataNascimento();
        }

        if (dto.cpf() != null) {
            if (!dto.cpf().equals(tutor.cpf) && Tutor.existsByCpf(dto.cpf())) {
                throw new IllegalArgumentException("Já existe um tutor cadastrado com este CPF.");
            }
            tutor.cpf = dto.cpf();
        }

        if (dto.rg() != null) {
            if (!dto.rg().equals(tutor.rg) && Tutor.existsByRg(dto.rg())) {
                throw new IllegalArgumentException("Já existe um tutor cadastrado com este RG.");
            }
            tutor.rg = dto.rg();
        }

        if (dto.email() != null) {
            if (!dto.email().equals(tutor.email) && Tutor.existsByEmail(dto.email())) {
                throw new IllegalArgumentException("Já existe um tutor cadastrado com este e-mail.");
            }
            tutor.email = dto.email();
        }

        if (dto.telefone() != null) {
            tutor.telefone = dto.telefone();
        }

        return montarResponse(tutor);
    }

}