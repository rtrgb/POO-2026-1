package br.com.clinicavet.consulta;

import java.time.LocalDateTime;
import java.util.List;

import br.com.clinicavet.animal.Animal;
import br.com.clinicavet.shared.enums.StatusConsulta;
import br.com.clinicavet.veterinario.Veterinario;
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
@Table(name = "consulta")
public class Consulta extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    public Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinario_id", nullable = false)
    public Veterinario veterinario;

    @Column(name = "data_hora", nullable = false)
    public LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public StatusConsulta status = StatusConsulta.AGENDADA;

    @Column(columnDefinition = "TEXT")
    public String observacoes;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    public LocalDateTime dataCriacao;

    public static List<Consulta> findByStatus(StatusConsulta status) {
        return list("status", status);
    }

    public static List<Consulta> findByAnimal(Long animalId) {
        return list("animal.id", animalId);
    }

    public static List<Consulta> findByVeterinario(Long veterinarioId) {
        return list("veterinario.id", veterinarioId);
    }

    public static List<Consulta> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return list("dataHora >= ?1 and dataHora <= ?2", inicio, fim);
    }
}