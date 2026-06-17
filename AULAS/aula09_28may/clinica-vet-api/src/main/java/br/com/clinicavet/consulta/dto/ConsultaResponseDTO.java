package br.com.clinicavet.consulta.dto;

import java.time.LocalDateTime;

import br.com.clinicavet.shared.enums.StatusConsulta;

public class ConsultaResponseDTO {

    public Long id;
    public Long animalId;
    public String animalNome;
    public Long veterinarioId;
    public String veterinarioNome;
    public LocalDateTime dataHora;
    public StatusConsulta status;
    public String observacoes;
    public LocalDateTime dataCriacao;
}