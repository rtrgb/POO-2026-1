package aula02_05mar;



import java.time.LocalDate;


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
}
