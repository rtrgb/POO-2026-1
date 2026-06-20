package br.com.clinicavetq.veterinario.dto;

import br.com.clinicavetq.veterinario.model.Especialidade;
import jakarta.validation.constraints.Email;

public record VeterinarioPatchDTO(

        String nome,

        String cpf,

        String crmv,

        @Email
        String email,

        String telefone,

        Especialidade especialidade,

        EnderecoDTO endereco

) {
}