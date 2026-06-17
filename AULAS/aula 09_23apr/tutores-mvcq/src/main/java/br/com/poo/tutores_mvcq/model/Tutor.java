package br.com.poo.tutores_mvcq.model;

import java.time.LocalDate;

public class Tutor {

    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String email;
    private String profissao;
    private int diaPagamento;

    public Tutor(int id, String nome, LocalDate dataNascimento,
                 String endereco, String email, String profissao, int diaPagamento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.profissao = profissao;
        this.diaPagamento = diaPagamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public int getDiaPagamento() { return diaPagamento; }
    public void setDiaPagamento(int diaPagamento) { this.diaPagamento = diaPagamento; }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Nascimento: " + dataNascimento +
               " | Endereço: " + endereco +
               " | Email: " + email +
               " | Profissão: " + profissao +
               " | Dia Pagamento: " + diaPagamento;
    }
}
