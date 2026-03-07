package aula02_05mar;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Pessoa {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String email;

    // Construtor
    public Pessoa(int id, String nome, LocalDate dataNascimento, String endereco, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
    }

    
    // Getters e Setters

    // Getter para 'id'
    public int getId() {
        return id;
    }

    // Setter para 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter para 'nome'
    public String getNome() {
        return nome;
    }

    // Setter para 'nome'
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para 'dataNascimento'
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Setter para 'dataNascimento'
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Getter para 'endereco'
    public String getEndereco() {
        return endereco;
    }

    // Setter para 'endereco'
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter para 'email'
    public String getEmail() {
        return email;
    }

    // Setter para 'email'
    public void setEmail(String email) {
        this.email = email;
    }

    public int calcularIdade() {
        int idade = Period.between(this.dataNascimento, LocalDate.now()).getYears();
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa = " + id + ", Nome='" + nome + "',endereco='" + endereco + "', email='" + email + "'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals (email, other.email) && id == other.id;
    }
}