package aula02_05mar;

import java.time.LocalDate;
import java.util.Objects;


public class Tutor extends Pessoa {

    private String profissao;
    private int diaPagamento;
    
    public Tutor(int id, String nome, LocalDate dataNascimento, String endereco, String email, String profissao, int diaPagamento){
        super(id, nome, dataNascimento, endereco, email);
        this.profissao = profissao;
        this.diaPagamento = diaPagamento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }


    @Override
    public String toString() {
        return "Tutor = " + getId() +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", endereco='" + getEndereco() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", profissao='" + profissao + '\'' +
                ", diaPagamento=" + diaPagamento +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tutor other = (Tutor) obj;
        return getId() == other.getId() && Objects.equals(getNome(), other.getNome());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId(),getNome());
    }
}
