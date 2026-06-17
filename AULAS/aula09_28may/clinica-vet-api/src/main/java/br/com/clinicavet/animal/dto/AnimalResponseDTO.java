package br.com.clinicavet.animal.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.clinicavet.animal.model.Especie;
import br.com.clinicavet.animal.model.Porte;
import br.com.clinicavet.animal.model.Sexo;

public class AnimalResponseDTO {

    public Long id;
    public String nome;
    public String raca;
    public Sexo sexo;
    public Especie especie;
    public LocalDate dataNascimento;
    public String rga;
    public Boolean vivo;
    public Boolean castrado;
    public String corPelagem;
    public Porte porte;
    public Float peso;
    public String observacoes;
    public Long tutorId;
    public String tutorNome;
    public LocalDateTime dataCriacao;
}