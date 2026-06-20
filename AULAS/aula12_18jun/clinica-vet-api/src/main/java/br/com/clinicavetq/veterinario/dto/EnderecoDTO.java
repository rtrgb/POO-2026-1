package br.com.clinicavetq.veterinario.dto;

public record EnderecoDTO(
        String cep,
        String rua,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado
) {
}
