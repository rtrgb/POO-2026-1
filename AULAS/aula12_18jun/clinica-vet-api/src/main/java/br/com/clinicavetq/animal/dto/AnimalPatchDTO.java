package br.com.clinicavetq.animal.dto;

import java.time.LocalDate;

import br.com.clinicavetq.animal.model.Especie;
import br.com.clinicavetq.animal.model.Porte;
import br.com.clinicavetq.animal.model.Sexo;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public record AnimalPatchDTO(

        String nome,

        String raca,

        Sexo sexo,

        Especie especie,

        @Past(message = "Data de nascimento deve ser anterior à data atual")
        LocalDate dataNascimento,

        String rga,

        Boolean castrado,

        String corPelagem,

        Porte porte,

        @Positive(message = "Peso deve ser maior que zero")
        Float peso,

        String observacoes,

        Long idTutor

) {
}