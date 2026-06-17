package br.com.poo.tutores_mvcq;

import br.com.poo.tutores_mvcq.controller.VeterinarioController;
import br.com.poo.tutores_mvcq.controller.VeterinarioControllerInterface;
import br.com.poo.tutores_mvcq.model.Especialidade;
import br.com.poo.tutores_mvcq.model.Veterinario;
import br.com.poo.tutores_mvcq.view.TutorView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // =========================================================
        // TESTES - VeterinarioController (Atividade em Sala 02)
        // =========================================================
        System.out.println("========== TESTES VETERINARIO ==========\n");

        VeterinarioControllerInterface vetController = new VeterinarioController();

        // Cadastrar veterinários
        vetController.cadastrarVeterinario(
                "Dr. João Silva", "111.222.333-44", "CRMV-SC 12345",
                "joao@clinica.com", "(47) 99999-1111",
                Especialidade.CLINICA_GERAL, "Rua das Flores, 10");

        vetController.cadastrarVeterinario(
                "Dra. Ana Souza", "555.666.777-88", "CRMV-SC 67890",
                "ana@clinica.com", "(47) 99999-2222",
                Especialidade.DERMATOLOGIA, "Av. Central, 200");

        vetController.cadastrarVeterinario(
                "Dr. Pedro Costa", "999.000.111-22", "CRMV-SC 11111",
                "pedro@clinica.com", "(47) 99999-3333",
                Especialidade.CIRURGIA, "Rua do Parque, 55");

        // Listar todos
        System.out.println("--- Listar todos os veterinários ---");
        List<Veterinario> lista = vetController.listarVeterinarios();
        for (Veterinario v : lista) {
            System.out.println(v);
        }

        // Buscar por ID
        System.out.println("\n--- Buscar veterinário ID 2 ---");
        Veterinario encontrado = vetController.buscarVeterinarioPorId(2);
        System.out.println(encontrado != null ? encontrado : "Não encontrado.");

        // Atualizar
        System.out.println("\n--- Atualizar veterinário ID 1 (novo telefone e especialidade) ---");
        boolean atualizou = vetController.atualizarVeterinario(
                1, null, null, null,
                null, "(47) 98888-0000",
                Especialidade.CARDIOLOGIA, null);
        System.out.println(atualizou ? "Atualizado com sucesso." : "Não encontrado.");
        System.out.println(vetController.buscarVeterinarioPorId(1));

        // Remover
        System.out.println("\n--- Remover veterinário ID 3 ---");
        boolean removeu = vetController.removerVeterinario(3);
        System.out.println(removeu ? "Removido com sucesso." : "Não encontrado.");

        // Listar após remoção
        System.out.println("\n--- Lista após remoção ---");
        for (Veterinario v : vetController.listarVeterinarios()) {
            System.out.println(v);
        }

        System.out.println("\n========== FIM DOS TESTES ==========\n");

        // =========================================================
        // MENU INTERATIVO - Tutores
        // =========================================================
        TutorView view = new TutorView();
        view.iniciar();
    }
}
