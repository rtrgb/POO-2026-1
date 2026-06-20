package br.com.clinicavetq.animal.dto;

import java.time.LocalDate;

import br.com.clinicavetq.animal.model.Especie;
import br.com.clinicavetq.animal.model.Porte;
import br.com.clinicavetq.animal.model.Sexo;
import br.com.clinicavetq.tutor.dto.TutorDadosDTO;

public record AnimalResponseDTO(
        Long id,
        String nome,
        String raca,
        Sexo sexo,
        Especie especie,
        LocalDate dataNascimento,
        String rga,
        Boolean vivo,
        Boolean castrado,
        String corPelagem,
        Porte porte,
        Float peso,
        String observacoes,
        TutorDadosDTO tutor
) {
}



