package br.com.clinicavetq.animal.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import br.com.clinicavetq.tutor.model.Tutor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    
    public static Optional<Animal> findAnimalById(Long id) {
        return findByIdOptional(id);
    }

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
