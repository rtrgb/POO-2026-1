package br.com.clinicavet.consulta.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class ConsultaAgendamentoDTO {

    @NotNull(message = "ID do animal é obrigatório")
    public Long animalId;

    @NotNull(message = "ID do veterinário é obrigatório")
    public Long veterinarioId;

    @NotNull(message = "Data e hora são obrigatórias")
    @Future(message = "A data da consulta deve ser no futuro")
    public LocalDateTime dataHora;

    public String observacoes;
}