package br.com.clinicavet.veterinario;

import java.util.Optional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinario")
public class Veterinario extends PanacheEntity {

    @Column(nullable = false)
    public String nome;

    @Column(nullable = false, unique = true)
    public String crmv;

    @Column(nullable = false)
    public String especialidade;

    @Column(nullable = false)
    public String telefone;

    @Column(nullable = false, unique = true)
    public String email;

    public static Optional<Veterinario> findByCrmv(String crmv) {
        return find("crmv", crmv).firstResultOptional();
    }

    public static boolean existsByCrmv(String crmv) {
        return count("crmv", crmv) > 0;
    }

    public static boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }
}