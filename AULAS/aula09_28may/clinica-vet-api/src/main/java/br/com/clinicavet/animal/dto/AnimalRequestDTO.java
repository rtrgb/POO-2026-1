package br.com.clinicavet.animal.dto;

import java.time.LocalDate;

import br.com.clinicavet.animal.model.Especie;
import br.com.clinicavet.animal.model.Porte;
import br.com.clinicavet.animal.model.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public class AnimalRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotBlank(message = "Raça é obrigatória")
    public String raca;

    @NotNull(message = "Sexo é obrigatório")
    public Sexo sexo;

    @NotNull(message = "Espécie é obrigatória")
    public Especie especie;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    public LocalDate dataNascimento;

    @NotBlank(message = "RGA é obrigatório")
    public String rga;

    public Boolean castrado = false;

    @NotBlank(message = "Cor da pelagem é obrigatória")
    public String corPelagem;

    @NotNull(message = "Porte é obrigatório")
    public Porte porte;

    @NotNull(message = "Peso é obrigatório")
    @Positive(message = "Peso deve ser positivo")
    public Float peso;

    public String observacoes;

    @NotNull(message = "ID do tutor é obrigatório")
    public Long tutorId;
}