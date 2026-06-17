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
        this.id = id; //signiifica que o ID do construtor é igual ao ID do objeto (private int id)
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

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