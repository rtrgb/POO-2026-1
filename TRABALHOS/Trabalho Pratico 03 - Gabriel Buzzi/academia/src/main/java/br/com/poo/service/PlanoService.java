package br.com.poo.service;

import java.util.List;
import br.com.poo.model.Plano;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PlanoService {

    public List<Plano> listarTodos() {
        return Plano.listAll();
    }

    public Plano buscarPorId(Long id) {
        return Plano.findById(id);
    }

    @Transactional // transacional pois se algum falhar ele não completa, apenas ações de
                   // criar/atualizar necessitam, as de ler não são transações.
    public Plano criar(Plano plano) {
        plano.persist();
        return plano;
    }

    @Transactional
    public Plano atualizar(Long id, Plano dadosNovos) {
        Plano plano = Plano.findById(id);
        if (plano == null) {
            return null;
        }
        plano.setNome(dadosNovos.getNome());
        plano.setDescricao(dadosNovos.getDescricao());
        plano.setValor(dadosNovos.getValor());
        plano.setDuracao(dadosNovos.getDuracao());
        return plano;
    }

    @Transactional
    public boolean deletar(Long id) {
        Plano plano = Plano.findById(id);
        if (plano == null) {
            return false;
        }
        plano.delete();
        return true;
    }

}
