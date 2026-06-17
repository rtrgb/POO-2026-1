package br.com.poo.academia.model;

public class Plano {

    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private int duracao; // meses

    public Plano() {
    }

    public Plano(int id, String nome, String descricao, double valor, int duracao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.duracao = duracao;
    }

    public Plano(String nome, String descricao, double valor, int duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.duracao = duracao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Nome: %s | Duracao: %d mes(es) | Valor: R$ %.2f | Descricao: %s",
            id, nome, duracao, valor, descricao
        );
    }

}
