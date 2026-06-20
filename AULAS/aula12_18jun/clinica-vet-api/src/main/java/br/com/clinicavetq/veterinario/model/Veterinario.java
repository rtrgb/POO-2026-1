package br.com.clinicavetq.veterinario.model;

import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinario")
public class Veterinario extends PanacheEntity {

    @Column(nullable = false)
    public String nome;

    @Column(nullable = false, unique = true)
    public String cpf;

    @Column(nullable = false, unique = true)
    public String crmv;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Especialidade especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    public Endereco endereco;

    @CreationTimestamp
    @Column(name = "data_criacao",
            nullable = false,
            updatable = false)
    public LocalDateTime dataCriacao;

    public static Optional<Veterinario> findVeterinarioById(Long id) {
        return findByIdOptional(id);
    }

    public static Optional<Veterinario> findByCpf(String cpf) {
        return find("cpf", cpf).firstResultOptional();
    }

    public static Optional<Veterinario> findByCrmv(String crmv) {
        return find("crmv", crmv).firstResultOptional();
    }

    public static Optional<Veterinario> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public static boolean existsByCpf(String cpf) {
        return count("cpf", cpf) > 0;
    }

    public static boolean existsByCrmv(String crmv) {
        return count("crmv", crmv) > 0;
    }

    public static boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }
}
