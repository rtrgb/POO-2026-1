package aula03_12mar;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Criando alguns livros
        Livro livro1 = new Livro(1, "O Senhor dos Anéis", "1954", 1, 1178, "978-0544003415");
        Livro livro2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "1997", 1, 309, "978-0590353427");

        // Criando alguns sócios
        Socio socio1 = new Socio(1, "João Silva", "123.456.789-00", "joao.silva@email.com", "11987654321", statusSocio.ATIVO);
        Socio socio2 = new Socio(2, "Maria Oliveira", "987.654.321-00", "maria.oliveira@email.com", "11987654321", statusSocio.ATIVO);

        // Criando um empréstimo
        Emprestimo emprestimo1 = new Emprestimo(1, LocalDate.now(), LocalDate.now().plusDays(14), null, statusEmprestimo.EM_ANDAMENTO);
        
        // Exibindo informações
        System.out.println("Livro 1:");
        System.out.println(livro1);
        System.out.println("Livro 2:");
        System.out.println(livro2);
        System.out.println("Sócio 1:");
        System.out.println(socio1);
        System.out.println("Sócio 2:");
        System.out.println(socio2);
        System.out.println("Empréstimo 1:");
        System.out.println(emprestimo1);

    }
}