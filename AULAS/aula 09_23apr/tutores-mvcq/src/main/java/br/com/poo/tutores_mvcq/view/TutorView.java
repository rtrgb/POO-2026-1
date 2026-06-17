package br.com.poo.tutores_mvcq.view;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import br.com.poo.tutores_mvcq.controller.TutorController;
import br.com.poo.tutores_mvcq.controller.TutorControllerInterface;
import br.com.poo.tutores_mvcq.model.Tutor;


public class TutorView {

    private Scanner scanner;
    private TutorControllerInterface controller;

    public TutorView() {
        scanner = new Scanner(System.in);
        controller = new TutorController();
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarTutor();
                    break;
                case 2:
                    listarTutores();
                    break;
                case 3:
                    buscarTutorPorId();
                    break;
                case 4:
                    atualizarTutor();
                    break;
                case 5:
                    removerTutor();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n===== MENU DE TUTORES =====");
        System.out.println("1 - Cadastrar tutor");
        System.out.println("2 - Listar tutores");
        System.out.println("3 - Buscar tutor por id");
        System.out.println("4 - Atualizar tutor");
        System.out.println("5 - Remover tutor");
        System.out.println("0 - Sair");
    }

    // cadastro de tutor
    private void cadastrarTutor() {
        System.out.println("\n--- Cadastro de Tutor ---");

        String nome = lerTextoObrigatorio("Nome: ");
        LocalDate dataNascimento = lerDataObrigatoria("Data de nascimento (AAAA-MM-DD): ");
        String endereco = lerTextoObrigatorio("Endereço: ");
        String email = lerTextoObrigatorio("Email: ");
        String profissao = lerTextoObrigatorio("Profissão: ");
        int diaPagamento = lerInteiro("Dia de pagamento: ");

        boolean cadastrou = controller.cadastrarTutor(
                nome,
                dataNascimento,
                endereco,
                email,
                profissao,
                diaPagamento
        );

        if (cadastrou) {
            System.out.println("Tutor cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar tutor.");
        }
    }


    // listagem de tutores
    private void listarTutores() {
        System.out.println("\n--- Lista de Tutores ---");

        List<Tutor> tutores = controller.listarTutores();

        if (tutores.isEmpty()) {
            System.out.println("Nenhum tutor cadastrado.");
            return;
        }

        for (Tutor tutor : tutores) {
            System.out.println(tutor);
        }
    }


    // busca de tutor por id
    private void buscarTutorPorId() {
        System.out.println("\n--- Buscar Tutor por Id ---");

        int id = lerInteiro("Informe o id: ");
        Tutor tutor = controller.buscarTutorPorId(id);

        if (tutor != null) {
            System.out.println(tutor);
        } else {
            System.out.println("Tutor não encontrado.");
        }
    }


    // ATUALIZAÇÃO (PATCH)
    private void atualizarTutor() {
        System.out.println("\n--- Atualização de Tutor ---");

        int id = lerInteiro("Id do tutor: ");

        System.out.println("Pressione ENTER para não alterar o campo.");

        String nome = lerTextoOpcional("Novo nome: ");
        LocalDate dataNascimento = lerDataOpcional("Nova data de nascimento (AAAA-MM-DD): ");
        String endereco = lerTextoOpcional("Novo endereço: ");
        String email = lerTextoOpcional("Novo email: ");
        String profissao = lerTextoOpcional("Nova profissão: ");
        Integer diaPagamento = lerInteiroOpcional("Novo dia de pagamento: ");

        boolean atualizou = controller.atualizarTutor(
                id,
                nome,
                dataNascimento,
                endereco,
                email,
                profissao,
                diaPagamento
        );

        if (atualizou) {
            System.out.println("Tutor atualizado com sucesso.");
        } else {
            System.out.println("Tutor não encontrado.");
        }
    }

    // remocao de tutores
    private void removerTutor() {
        System.out.println("\n--- Remoção de Tutor ---");

        int id = lerInteiro("Id do tutor: ");
        boolean removeu = controller.removerTutor(id);

        if (removeu) {
            System.out.println("Tutor removido com sucesso.");
        } else {
            System.out.println("Tutor não encontrado.");
        }
    }


    // metodos auxiliares
    // ler valor inteiro obrigatorio
    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (Exception e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    // 	ler valor inteiro opcional
    private Integer lerInteiroOpcional(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine();

        if (valor.trim().isEmpty()) {
            return null;
        }

        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            System.out.println("Valor inválido. Campo não será alterado.");
            return null;
        }
    }

    // 	ler valor string obrigatorio
    private String lerTextoObrigatorio(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = scanner.nextLine();

            if (!valor.trim().isEmpty()) {
                return valor;
            }

            System.out.println("Campo obrigatório. Tente novamente.");
        }
    }

    // ler valor string opcional
    private String lerTextoOpcional(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine();
        return valor.trim().isEmpty() ? null : valor;
    }

    // ler data obrigatoria
    private LocalDate lerDataObrigatoria(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Data inválida. Use o formato AAAA-MM-DD.");
            }
        }
    }

    // ler data opcional
    private LocalDate lerDataOpcional(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine();

        if (valor.trim().isEmpty()) {
            return null;
        }

        try {
            return LocalDate.parse(valor);
        } catch (Exception e) {
            System.out.println("Data inválida. Campo não será alterado.");
            return null;
        }
    }
}
