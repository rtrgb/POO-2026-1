package br.com.clinicavetq.animal.dto;

import java.time.LocalDate;

import br.com.clinicavetq.animal.model.Especie;
import br.com.clinicavetq.animal.model.Porte;
import br.com.clinicavetq.animal.model.Sexo;

public record AnimalDadosDTO(
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
        String observacoes
) {
}