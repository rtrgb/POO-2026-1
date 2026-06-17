package br.com.clinicavet.animal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

import br.com.clinicavet.animal.model.Especie;
import br.com.clinicavet.animal.model.Porte;
import br.com.clinicavet.animal.model.Sexo;
import br.com.clinicavet.tutor.Tutor;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "animal")
public class Animal extends PanacheEntity {

    @Column(nullable = false, length = 100)
    public String nome;

    @Column(nullable = false, length = 80)
    public String raca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public Sexo sexo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    public Especie especie;

    @Column(name = "data_nascimento", nullable = false)
    public LocalDate dataNascimento;

    @Column(nullable = false, length = 30, unique = true)
    public String rga;

    @Column(nullable = false)
    public Boolean vivo = true;

    @Column(nullable = false)
    public Boolean castrado = false;

    @Column(name = "cor_pelagem", nullable = false, length = 30)
    public String corPelagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public Porte porte;

    @Column(nullable = false)
    public Float peso;

    @Column(columnDefinition = "TEXT", nullable = false)
    public String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", nullable = false)
    public Tutor tutor;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    public LocalDateTime dataCriacao;

    public static Optional<Animal> findByRga(String rga) {
        return find("rga", rga).firstResultOptional();
    }

    public static List<Animal> findByTutor(Long idTutor) {
        return list("tutor.id", idTutor);
    }

    public static boolean existsByRga(String rga) {
        return count("rga", rga) > 0;
    }
}