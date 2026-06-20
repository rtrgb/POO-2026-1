package br.com.clinicavetq.tutor.dto;

import java.util.List;

import br.com.clinicavetq.animal.dto.AnimalDadosDTO;

public record TutorResponseDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        List<AnimalDadosDTO> animais
) {
}