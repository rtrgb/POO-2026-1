package aula03_12mar;

import java.util.Objects;

public class Socio {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private statusSocio statusSocio;


    public Socio(int id, String nome, String cpf, String email, String telefone, statusSocio statusSocio) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.statusSocio = statusSocio;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public statusSocio getStatusSocio() {
        return statusSocio;
    }

    public void setStatusSocio(statusSocio statusSocio) {
        this.statusSocio = statusSocio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Socio other = (Socio) obj;
        return getId() == other.getId() && Objects.equals(getCpf(), other.getCpf());
    }   

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf());
    }   

    @Override
    public String toString() {
        return "Socio = " + getId() +
                ",\n nome='" + getNome() +
                ",\n cpf='" + getCpf() +
                ",\n email='" + getEmail() +
                ",\n telefone='" + getTelefone() +
                ",\n statusSocio=" + getStatusSocio() +
                '}' + "\n\n";
    }
}
