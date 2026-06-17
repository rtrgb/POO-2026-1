package br.com.poo.tutores_mvcq.controller;

import br.com.poo.tutores_mvcq.model.Especialidade;
import br.com.poo.tutores_mvcq.model.Veterinario;

import java.util.ArrayList;
import java.util.List;

public class VeterinarioController implements VeterinarioControllerInterface {

    private List<Veterinario> veterinarios = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public boolean cadastrarVeterinario(String nome, String cpf, String crmv,
                                        String email, String telefone,
                                        Especialidade especialidade, String endereco) {
        try {
            Veterinario v = new Veterinario(proximoId++, nome, cpf, crmv,
                    email, telefone, especialidade, endereco);
            veterinarios.add(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Veterinario> listarVeterinarios() {
        return veterinarios;
    }

    @Override
    public Veterinario buscarVeterinarioPorId(int id) {
        for (Veterinario v : veterinarios) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    @Override
    public boolean atualizarVeterinario(int id, String nome, String cpf, String crmv,
                                         String email, String telefone,
                                         Especialidade especialidade, String endereco) {
        Veterinario v = buscarVeterinarioPorId(id);
        if (v == null) return false;

        if (nome != null)          v.setNome(nome);
        if (cpf != null)           v.setCpf(cpf);
        if (crmv != null)          v.setCrmv(crmv);
        if (email != null)         v.setEmail(email);
        if (telefone != null)      v.setTelefone(telefone);
        if (especialidade != null) v.setEspecialidade(especialidade);
        if (endereco != null)      v.setEndereco(endereco);

        return true;
    }

    @Override
    public boolean removerVeterinario(int id) {
        return veterinarios.removeIf(v -> v.getId() == id);
    }
}
