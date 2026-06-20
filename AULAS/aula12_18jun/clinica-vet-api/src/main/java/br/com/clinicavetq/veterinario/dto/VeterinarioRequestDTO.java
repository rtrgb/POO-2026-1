package br.com.clinicavetq.veterinario.dto;

import br.com.clinicavetq.veterinario.model.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeterinarioRequestDTO(

        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @NotBlank
        String crmv,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotNull
        Especialidade especialidade,

        @NotNull
        EnderecoDTO endereco

) {
}