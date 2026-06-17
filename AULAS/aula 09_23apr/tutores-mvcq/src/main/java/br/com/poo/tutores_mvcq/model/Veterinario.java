package br.com.poo.tutores_mvcq.model;

import java.time.LocalDateTime;

public class Veterinario {

    private final int id;
    private String nome;
    private String cpf;
    private String crmv;
    private String email;
    private String telefone;
    private Especialidade especialidade;
    private String endereco;
    private LocalDateTime dataCriacao;

    public Veterinario(int id, String nome, String cpf, String crmv,
                       String email, String telefone, Especialidade especialidade,
                       String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.crmv = crmv;
        this.email = email;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.dataCriacao = LocalDateTime.now();
    }

    public int getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCrmv() { return crmv; }
    public void setCrmv(String crmv) { this.crmv = crmv; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | CPF: " + cpf +
               " | CRMV: " + crmv +
               " | Email: " + email +
               " | Telefone: " + telefone +
               " | Especialidade: " + especialidade +
               " | Endereço: " + endereco +
               " | Criado em: " + dataCriacao;
    }
}
