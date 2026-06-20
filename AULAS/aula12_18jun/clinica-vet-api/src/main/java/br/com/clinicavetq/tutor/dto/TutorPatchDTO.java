package br.com.clinicavetq.tutor.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

public record TutorPatchDTO(

        String nome,

        @Past(message = "Data de nascimento deve ser anterior à data atual")
        LocalDate dataNascimento,

        String cpf,

        String rg,

        @Email(message = "E-mail inválido")
        String email,

        String telefone

) {
}
