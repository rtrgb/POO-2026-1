package br.com.clinicavetq.veterinario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String cep;

    @Column(nullable = false)
    public String rua;

    @Column(nullable = false)
    public String numero;

    public String complemento;

    @Column(nullable = false)
    public String bairro;

    @Column(nullable = false)
    public String cidade;

    @Column(nullable = false)
    public String estado;
}
