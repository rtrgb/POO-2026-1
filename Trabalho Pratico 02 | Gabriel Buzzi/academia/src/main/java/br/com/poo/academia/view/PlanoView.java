package br.com.poo.academia.view;

import br.com.poo.academia.controller.PlanoController;
import br.com.poo.academia.controller.PlanoControllerInterface;
import br.com.poo.academia.model.Plano;

import java.util.List;
import java.util.Scanner;

public class PlanoView {

    private Scanner scanner;
    private PlanoControllerInterface controller;

    public PlanoView() {
        this.scanner = new Scanner(System.in);
        this.controller = new PlanoController();
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarPlano();
                    break;
                case 2:
                    listarPlanos();
                    break;
                case 3:
                    buscarPlanoPorId();
                    break;
                case 4:
                    atualizarPlano();
                    break;
                case 5:
                    removerPlano();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n===== MENU DE PLANOS =====");
        System.out.println("1 - Cadastrar plano");
        System.out.println("2 - Listar planos");
        System.out.println("3 - Buscar plano por ID");
        System.out.println("4 - Atualizar plano");
        System.out.println("5 - Remover plano");
        System.out.println("0 - Sair");
    }

    // cadastro
    private void cadastrarPlano() {
        System.out.println("\n--- Cadastro de Plano ---");

        String nome      = lerTextoObrigatorio("Nome: ");
        String descricao = lerTextoObrigatorio("Descricao: ");
        double valor     = lerDouble("Valor (R$): ");
        int duracao      = lerInteiro("Duracao (em meses): ");

        boolean cadastrou = controller.cadastrarPlano(nome, descricao, valor, duracao);

        if (cadastrou) {
            System.out.println("Plano cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar plano.");
        }
    }

    // lista
    private void listarPlanos() {
        System.out.println("\n--- Lista de Planos ---");

        List<Plano> planos = controller.listarPlanos();

        if (planos.isEmpty()) {
            System.out.println("Nenhum plano cadastrado.");
            return;
        }

        for (Plano plano : planos) {
            System.out.println(plano);
        }
    }

    // busca por id
    private void buscarPlanoPorId() {
        System.out.println("\n--- Buscar Plano por ID ---");

        int id = lerInteiro("Informe o ID: ");
        Plano plano = controller.buscarPlanoPorId(id);

        if (plano != null) {
            System.out.println(plano);
        } else {
            System.out.println("Plano nao encontrado.");
        }
    }

    // atualiza
    private void atualizarPlano() {
        System.out.println("\n--- Atualizacao de Plano ---");

        int id = lerInteiro("ID do plano: ");

        System.out.println("Pressione ENTER para nao alterar o campo.");

        String  nome      = lerTextoOpcional("Novo nome: ");
        String  descricao = lerTextoOpcional("Nova descricao: ");
        Double  valor     = lerDoubleOpcional("Novo valor (R$): ");
        Integer duracao   = lerInteiroOpcional("Nova duracao (em meses): ");

        boolean atualizou = controller.atualizarPlano(id, nome, descricao, valor, duracao);

        if (atualizou) {
            System.out.println("Plano atualizado com sucesso.");
        } else {
            System.out.println("Plano nao encontrado ou nenhum campo informado.");
        }
    }

    // remove
    private void removerPlano() {
        System.out.println("\n--- Remocao de Plano ---");

        int id = lerInteiro("ID do plano: ");
        boolean removeu = controller.removerPlano(id);

        if (removeu) {
            System.out.println("Plano removido com sucesso.");
        } else {
            System.out.println("Plano nao encontrado.");
        }
    }

    // helpers de leitura

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Valor invalido. Digite um numero inteiro.");
            }
        }
    }

    private Integer lerInteiroOpcional(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine();

        if (valor.trim().isEmpty()) {
            return null;
        }

        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            System.out.println("Valor invalido. Campo nao sera alterado.");
            return null;
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (Exception e) {
                System.out.println("Valor invalido. Use ponto ou virgula como separador decimal.");
            }
        }
    }

    private Double lerDoubleOpcional(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine();

        if (valor.trim().isEmpty()) {
            return null;
        }

        try {
            return Double.parseDouble(valor.replace(",", "."));
        } catch (Exception e) {
            System.out.println("Valor invalido. Campo nao sera alterado.");
            return null;
        }
    }

    private String lerTextoObrigatorio(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = scanner.nextLine();

            if (!valor.trim().isEmpty()) {
                return valor;
            }

            System.out.println("Campo obrigatorio. Tente novamente.");
        }
    }

    private String lerTextoOpcional(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine();
        return valor.trim().isEmpty() ? null : valor;
    }

}
