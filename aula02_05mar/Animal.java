package aula02_05mar;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Animal {
    private int id;
    private String nome;
    private Especie especie;
    private String raca;
    private float peso;
    private Sexo sexo;
    private LocalDate dataNascimento;

    public Animal(int id, String nome, Especie especie, String raca, float peso, Sexo sexo, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.peso = peso;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }   

    public Sexo getSexo() {
        return sexo;
    }   

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;

    }

    @Override
    public String toString() {
        return "Animal = " +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", peso=" + peso +
                ", sexo='" + sexo + '\'' +
                ", dataNascimento=" + dataNascimento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        return id == other.id && Objects.equals(nome, other.nome);
}

}