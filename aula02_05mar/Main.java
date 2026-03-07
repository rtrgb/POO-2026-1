package aula02_05mar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa(1, "Gabriel", LocalDate.of(2006, 2, 16), "Rua A, 123", "gabriel@email.com");
        Pessoa pessoa2 = new Pessoa(2, "Mariana", LocalDate.of(2005, 5, 25), "Rua A, 456", "jorge@email.com");
        Tutor tutor1 = new Tutor(1, "Gabriel", LocalDate.of(2006, 2, 16), "Rua A, 123", "gabriel@email.com", "Professor", 15);
        Medico medico1 = new Medico(1, "Dr. Silva", LocalDate.of(1980, 10, 5), "Rua B, 789", "dr.silva@email.com", "CRM-12345", Especialidade.cardiologia);
        Animal animal1 = new Animal(1, "Rex", Especie.cachorro, "Labrador", 30.5f, Sexo.macho, LocalDate.of(2020, 6, 10));
        Consulta consulta1 = new Consulta(LocalDate.of(2024, 3, 5), LocalTime.of(14, 30), "Consulta de rotina", medico1, tutor1, animal1);
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("=== MENU ===");
            System.out.println("1 - Pessoas");
            System.out.println("2 - Tutor");
            System.out.println("3 - Medico");
            System.out.println("4 - Consulta");
            System.out.println("5 - Animal");
            System.out.println("6 - Comparar pessoas");
            System.out.println("7 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n" + pessoa1);
                    System.out.println("Idade: " + pessoa1.calcularIdade());
                    System.out.println("Hashcode: " + pessoa1.hashCode());
                    System.out.println("\n" + pessoa2);
                    System.out.println("Idade: " + pessoa2.calcularIdade());
                    System.out.println("Hashcode: " + pessoa2.hashCode() + "\n");
                    break;
                case 2:
                    System.out.println("\n" + tutor1 + "\n");
                    break;
                case 3:
                    System.out.println("\n" + medico1 + "\n");
                    break;
                case 4:
                    System.out.println("\n" + consulta1 + "\n");
                    break;
                case 5:
                    System.out.println("\n" + animal1 + "\n");
                    break;
                case 6:
                    System.out.println("\nPessoas iguais? " + pessoa1.equals(pessoa2) + "\n");
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!\n");
            }
        }

        scanner.close();
    }
}