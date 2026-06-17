package br.com.poo.academia.controller;

import br.com.poo.academia.model.Plano;

import java.util.List;

public interface PlanoControllerInterface {

    boolean cadastrarPlano(String nome, String descricao, double valor, int duracao);

    List<Plano> listarPlanos();

    Plano buscarPlanoPorId(int id);

    boolean atualizarPlano(int id, String nome, String descricao, Double valor, Integer duracao);

    boolean removerPlano(int id);

}
