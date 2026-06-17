package br.com.poo.tutores_mvcq.controller;

import br.com.poo.tutores_mvcq.model.Tutor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TutorController implements TutorControllerInterface {

    private List<Tutor> tutores = new ArrayList<>();
    private int proximoId;

    public TutorController() {
        // Pre-loaded data from teacher's Tutores.txt
        tutores.add(new Tutor(1, "Carlos Souza", LocalDate.of(1985, 3, 10),
                "Rua das Palmeiras, 120", "carlos@email.com", "Professor", 5));
        tutores.add(new Tutor(2, "Mariana Alves", LocalDate.of(1992, 7, 21),
                "Av. Brasil, 450", "mariana@email.com", "Engenheira", 10));
        tutores.add(new Tutor(3, "Fernanda Lima", LocalDate.of(1988, 11, 2),
                "Rua Central, 89", "fernanda@email.com", "Veterinária", 15));
        tutores.add(new Tutor(4, "Ricardo Mendes", LocalDate.of(1979, 6, 18),
                "Rua das Acácias, 45", "ricardo@email.com", "Advogado", 8));
        tutores.add(new Tutor(5, "Juliana Rocha", LocalDate.of(1995, 1, 30),
                "Av. Atlântica, 980", "juliana@email.com", "Arquiteta", 12));
        tutores.add(new Tutor(6, "Paulo Henrique", LocalDate.of(1983, 9, 14),
                "Rua do Comércio, 210", "paulo@email.com", "Contador", 7));
        tutores.add(new Tutor(7, "Camila Duarte", LocalDate.of(1990, 4, 25),
                "Rua das Flores, 77", "camila@email.com", "Designer", 20));
        tutores.add(new Tutor(8, "Patrícia Gomes", LocalDate.of(1993, 8, 9),
                "Rua São João, 150", "patricia@email.com", "Enfermeira", 10));

        proximoId = 9;
    }

    @Override
    public boolean cadastrarTutor(String nome, LocalDate dataNascimento, String endereco,
                                  String email, String profissao, int diaPagamento) {
        try {
            Tutor tutor = new Tutor(proximoId++, nome, dataNascimento,
                    endereco, email, profissao, diaPagamento);
            tutores.add(tutor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Tutor> listarTutores() {
        return tutores;
    }

    @Override
    public Tutor buscarTutorPorId(int id) {
        for (Tutor t : tutores) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    @Override
    public boolean atualizarTutor(int id, String nome, LocalDate dataNascimento, String endereco,
                                  String email, String profissao, Integer diaPagamento) {
        Tutor t = buscarTutorPorId(id);
        if (t == null) return false;

        if (nome != null)            t.setNome(nome);
        if (dataNascimento != null)  t.setDataNascimento(dataNascimento);
        if (endereco != null)        t.setEndereco(endereco);
        if (email != null)           t.setEmail(email);
        if (profissao != null)       t.setProfissao(profissao);
        if (diaPagamento != null)    t.setDiaPagamento(diaPagamento);

        return true;
    }

    @Override
    public boolean removerTutor(int id) {
        return tutores.removeIf(t -> t.getId() == id);
    }
}
