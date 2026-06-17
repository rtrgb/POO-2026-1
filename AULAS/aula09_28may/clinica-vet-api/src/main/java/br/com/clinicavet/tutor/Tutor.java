package br.com.clinicavet.tutor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.clinicavet.animal.Animal;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tutor")
public class Tutor extends PanacheEntity {

    @Column(nullable = false)
    public String nome;

    @Column(name = "data_nascimento", nullable = false)
    public LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    public String cpf;

    @Column(nullable = false, unique = true)
    public String rg;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String telefone;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Animal> animais = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    public LocalDateTime dataCriacao;

    public static Optional<Tutor> findByCpf(String cpf) {
        return find("cpf", cpf).firstResultOptional();
    }

    public static Optional<Tutor> findByRg(String rg) {
        return find("rg", rg).firstResultOptional();
    }

    public static Optional<Tutor> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public static boolean existsByCpf(String cpf) {
        return count("cpf", cpf) > 0;
    }

    public static boolean existsByRg(String rg) {
        return count("rg", rg) > 0;
    }

    public static boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }
}