package br.com.clinicavetq.animal.dto;


import java.time.LocalDate;

import br.com.clinicavetq.animal.model.Especie;
import br.com.clinicavetq.animal.model.Porte;
import br.com.clinicavetq.animal.model.Sexo;
import jakarta.validation.constraints.*;

public record AnimalRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Raça é obrigatória")
        String raca,
        @NotNull(message = "Sexo é obrigatório")
        Sexo sexo,
        @NotNull(message = "Espécie é obrigatória")
        Especie especie,
        @NotNull(message = "Data de nascimento é obrigatória")
        @Past(message = "Data de nascimento deve ser anterior à data atual")
        LocalDate dataNascimento,
        @NotBlank(message = "RGA é obrigatório")
        String rga,
        @NotNull(message = "Informe se o animal é castrado")
        Boolean castrado,
        @NotBlank(message = "Cor da pelagem é obrigatória")
        String corPelagem,
        @NotNull(message = "Porte é obrigatório")
        Porte porte,
        @NotNull(message = "Peso é obrigatório")
        @Positive(message = "Peso deve ser maior que zero")
        Float peso,
        @NotBlank(message = "Observações são obrigatórias")
        String observacoes,
        @NotNull(message = "Tutor é obrigatório")
        Long idTutor
        
) {
}

