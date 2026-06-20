package br.com.clinicavetq.tutor.dto;

import java.time.LocalDate;

public record TutorDadosDTO(
        Long id,
        String nome,
        LocalDate dataNascimento,
        String cpf,
        String rg,
        String email,
        String telefone
) {
}