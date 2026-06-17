package br.com.clinicavet.tutor.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class TutorRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    public LocalDate dataNascimento;

    @NotBlank(message = "CPF é obrigatório")
    public String cpf;

    @NotBlank(message = "RG é obrigatório")
    public String rg;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    public String email;

    @NotBlank(message = "Telefone é obrigatório")
    public String telefone;
}