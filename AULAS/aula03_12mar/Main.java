package aula03_12mar;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------//

        Genero genero1 = new Genero(1, "Fantasia");
        Genero genero2 = new Genero(2, "Aventura");
        Genero genero3 = new Genero(3, "Ficção Científica");

        Autor autor1 = new Autor(1, "J.R.R. Tolkien");
        Autor autor2 = new Autor(2, "J.K. Rowling");
        Autor autor3 = new Autor(3, "Isaac Asimov");

        Editora editora1 = new Editora(1, "HarperCollins", "Rua das Flores, 123");
        Editora editora2 = new Editora(2, "Bloomsbury", "Avenida Central, 456");
        Editora editora3 = new Editora(3, "Galaxy Books", "Travessa das Estrelas, 789");

        Livro livro1 = new Livro(1, "O Senhor dos Anéis", "1954", 1, 1178, "978-0544003415");
        livro1.setGenero(genero1);
        livro1.setAutor(autor1);
        livro1.setEditora(editora1);

        Livro livro2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "1997", 1, 309, "978-0590353427");
        livro2.setGenero(genero2);
        livro2.setAutor(autor2);
        livro2.setEditora(editora2);

        Livro livro3 = new Livro(3, "Fundação", "1951", 1, 255, "978-0553293357");
        livro3.setGenero(genero3);
        livro3.setAutor(autor3);
        livro3.setEditora(editora3);

        List<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);

        // -------------------------------------------//

        Socio socio1 = new Socio(1, "João Silva", "123.456.789-00", "joao.silva@email.com", "11987654321",
                statusSocio.ATIVO);
        Socio socio2 = new Socio(2, "Maria Oliveira", "987.654.321-00", "maria.oliveira@email.com", "11987654321",
                statusSocio.ATIVO);

        List<Socio> socios = new ArrayList<>();
        socios.add(socio1);
        socios.add(socio2);

        // -------------------------------------------//

        List<Emprestimo> emprestimos = new ArrayList<>();

        Emprestimo emprestimo1 = new Emprestimo(1, LocalDate.now(), LocalDate.now().plusDays(14), null,
                statusEmprestimo.EM_ANDAMENTO);

        emprestimo1.setSocio(socio1);
        emprestimo1.setLivro(livro1);
        emprestimos.add(emprestimo1);

        // -------------------------------------------//
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Listar sócios");
            System.out.println("3 - Realizar empréstimo");
            System.out.println("4 - Listar empréstimos");
            System.out.println("5 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Livros ---");
                    for (Livro l : livros) {
                        System.out.println(l);
                    }
                    break;

                case 2:
                    System.out.println("\n--- Sócios ---");
                    for (Socio s : socios) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.println("\n--- Novo Empréstimo ---");

                    System.out.println("Escolha o sócio (id):");
                    for (Socio s : socios) {
                        System.out.println(s.getId() + " - " + s.getNome());
                    }
                    int idSocio = scanner.nextInt();

                    Socio socioEscolhido = null;
                    for (int i = 0; i < socios.size(); i++) {
                        if (socios.get(i).getId() == idSocio) {
                            socioEscolhido = socios.get(i);
                        }
                    }

                    System.out.println("Escolha o livro (id):");
                    for (Livro l : livros) {
                        System.out.println(l.getId() + " - " + l.getTitulo());
                    }
                    int idLivro = scanner.nextInt();

                    Livro livroEscolhido = null;
                    for (int i = 0; i < livros.size(); i++) {
                        if (livros.get(i).getId() == idLivro) {
                            livroEscolhido = livros.get(i);
                        }
                    }

                    if (socioEscolhido != null && livroEscolhido != null) {
                        Emprestimo novo = new Emprestimo(
                                emprestimos.size() + 1,
                                LocalDate.now(),
                                LocalDate.now().plusDays(14),
                                null,
                                statusEmprestimo.EM_ANDAMENTO);
                        novo.setSocio(socioEscolhido);
                        novo.setLivro(livroEscolhido);
                        emprestimos.add(novo);
                        System.out.println("Empréstimo realizado com sucesso!");
                    } else {
                        System.out.println("Sócio ou livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Empréstimos ---");
                    if (emprestimos.isEmpty()) {
                        System.out.println("Nenhum empréstimo registrado.");
                    } else {
                        for (Emprestimo e : emprestimos) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 5:
    System.out.println("\n--- Devolver Livro ---");
    System.out.println("Escolha o empréstimo (id):");
    for (Emprestimo e : emprestimos) {
        System.out.println(e.getId() + " - " + e.getLivro().getTitulo() + " (Sócio: " + e.getSocio().getNome() + ")");
    }
    int idEmprestimo = scanner.nextInt();

    Emprestimo emprestimoDevolucao = null;
    for (Emprestimo e : emprestimos) {
        if (e.getId() == idEmprestimo) {
            emprestimoDevolucao = e;
            break;
        }
    }

    if (emprestimoDevolucao != null) {
        if (emprestimoDevolucao.getStatusEmprestimo() == statusEmprestimo.DEVOLVIDO) {
            System.out.println("Este livro já foi devolvido!");
        } else {
            emprestimoDevolucao.setDataDevolvida(LocalDate.now()); 
            emprestimoDevolucao.setStatusEmprestimo(statusEmprestimo.DEVOLVIDO);
            System.out.println("Livro devolvido com sucesso!");
        }
    } else {
        System.out.println("Empréstimo não encontrado.");
    }
    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}