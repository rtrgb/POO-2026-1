package br.com.clinicavet.veterinario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class VeterinarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotBlank(message = "CRMV é obrigatório")
    public String crmv;

    @NotBlank(message = "Especialidade é obrigatória")
    public String especialidade;

    @NotBlank(message = "Telefone é obrigatório")
    public String telefone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    public String email;
}