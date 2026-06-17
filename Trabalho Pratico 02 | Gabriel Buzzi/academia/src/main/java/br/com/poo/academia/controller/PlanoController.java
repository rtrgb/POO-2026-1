package br.com.poo.academia.controller;

import br.com.poo.academia.dao.PlanoDAO;
import br.com.poo.academia.model.Plano;

import java.util.List;

public class PlanoController implements PlanoControllerInterface {

    private PlanoDAO planoDAO;

    public PlanoController() {
        this.planoDAO = new PlanoDAO();
    }

    @Override
    public boolean cadastrarPlano(String nome, String descricao, double valor, int duracao) {
        Plano plano = new Plano(nome, descricao, valor, duracao);
        return planoDAO.inserir(plano);
    }

    @Override
    public List<Plano> listarPlanos() {
        return planoDAO.listar();
    }

    @Override
    public Plano buscarPlanoPorId(int id) {
        return planoDAO.buscarPorId(id);
    }

    @Override
    public boolean atualizarPlano(int id, String nome, String descricao, Double valor, Integer duracao) {
        return planoDAO.atualizar(id, nome, descricao, valor, duracao);
    }

    @Override
    public boolean removerPlano(int id) {
        return planoDAO.remover(id);
    }

}
