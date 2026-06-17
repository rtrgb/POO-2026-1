package br.com.poo.tutores_mvcq.controller;

import br.com.poo.tutores_mvcq.model.Tutor;

import java.time.LocalDate;
import java.util.List;

public interface TutorControllerInterface {

    boolean cadastrarTutor(String nome, LocalDate dataNascimento, String endereco,
                           String email, String profissao, int diaPagamento);

    List<Tutor> listarTutores();

    Tutor buscarTutorPorId(int id);

    boolean atualizarTutor(int id, String nome, LocalDate dataNascimento, String endereco,
                           String email, String profissao, Integer diaPagamento);

    boolean removerTutor(int id);
}
