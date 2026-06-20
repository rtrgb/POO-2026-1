package br.com.clinicavetq.veterinario.dto;

import br.com.clinicavetq.veterinario.model.Especialidade;

public record VeterinarioDadosDTO(
        Long id,
        String nome,
        String cpf,
        String crmv,
        String email,
        String telefone,
        Especialidade especialidade
) {
}
