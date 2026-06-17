package br.com.poo.tutores_mvcq.controller;

import br.com.poo.tutores_mvcq.model.Especialidade;
import br.com.poo.tutores_mvcq.model.Veterinario;

import java.util.List;

public interface VeterinarioControllerInterface {

    boolean cadastrarVeterinario(String nome, String cpf, String crmv,
                                 String email, String telefone,
                                 Especialidade especialidade, String endereco);

    List<Veterinario> listarVeterinarios();

    Veterinario buscarVeterinarioPorId(int id);

    boolean atualizarVeterinario(int id, String nome, String cpf, String crmv,
                                  String email, String telefone,
                                  Especialidade especialidade, String endereco);

    boolean removerVeterinario(int id);
}
