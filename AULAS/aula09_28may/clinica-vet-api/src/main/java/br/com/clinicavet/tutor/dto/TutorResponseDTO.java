package br.com.clinicavet.tutor.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TutorResponseDTO {

    public Long id;
    public String nome;
    public LocalDate dataNascimento;
    public String cpf;
    public String rg;
    public String email;
    public String telefone;
    public LocalDateTime dataCriacao;
}