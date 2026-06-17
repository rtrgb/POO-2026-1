package aula02_05mar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa(1, "Gabriel", LocalDate.of(2006, 2, 16), "Rua A, 123", "gabriel@email.com");
        Pessoa pessoa2 = new Pessoa(2, "Mariana", LocalDate.of(2005, 5, 25), "Rua A, 456", "jorge@email.com");

        Animal animal1 = new Animal(1, "Rex", Especie.cachorro, "Labrador", 30.5f, Sexo.macho, LocalDate.of(2020, 6, 10));
        Animal animal2 = new Animal(2, "Bella", Especie.gato, "Siamês", 5.2f, Sexo.femea, LocalDate.of(2019, 8, 15));
        Animal animal3 = new Animal(3, "Max", Especie.cachorro, "Dachshund", 15.0f, Sexo.macho, LocalDate.of(2021, 1, 20));
        Animal animal4 = new Animal(4, "Luna", Especie.gato, "Maine Coon", 7.8f, Sexo.femea, LocalDate.of(2018, 11, 5));
        Animal animal5 = new Animal(5, "Charlie", Especie.cachorro, "Bulldog", 25.0f, Sexo.macho, LocalDate.of(2019, 4, 30));
        Animal animal6 = new Animal(6, "Mia", Especie.gato, "Persa", 4.5f, Sexo.femea, LocalDate.of(2020, 9, 12));
       
        Tutor tutor1 = new Tutor(1,"Marcelo", LocalDate.of(1977, 11, 16),"Rua Jose Beiro", "mauricio@email.com", "Professor", 15);
        tutor1.adicionarAnimal(animal1);
        tutor1.adicionarAnimal(animal2);
        tutor1.adicionarAnimal(animal3);

		Tutor tutor2 = new Tutor(2,"Ana Paula", LocalDate.of(1985, 3, 22),"Rua das Flores", "ana.paula@email.com", "Veterinária", 8);
        tutor2.adicionarAnimal(animal4);

		Tutor tutor3 = new Tutor(3,"Carlos Henrique", LocalDate.of(1990, 7, 10),"Av. Brasil", "carlos.h@email.com", "Engenheiro", 4);
        tutor3.adicionarAnimal(animal5);
        tutor3.adicionarAnimal(animal6);

		Tutor tutor4 = new Tutor(4,"Fernanda Souza", LocalDate.of(1982, 9, 5),"Rua do Comércio", "fernanda.s@email.com", "Advogada", 12);

		Tutor tutor5 = new Tutor(5,"Ricardo Lima", LocalDate.of(1975, 1, 30),"Av. Atlântica", "ricardo.l@email.com", "Empresário", 20);

		Tutor tutor6 = new Tutor(6,"Juliana Martins", LocalDate.of(1993, 6, 14),"Rua das Palmeiras", "juliana.m@email.com", "Arquiteta", 3);

        List<Tutor> tutores = new ArrayList<>();
        tutores.add(tutor1);
        tutores.add(tutor2);
        tutores.add(tutor3);
        tutores.add(tutor4);
        tutores.add(tutor5);
        tutores.add(tutor6);
       
        Medico medico1 = new Medico(1, "Dr. Silva", LocalDate.of(1980, 10, 5), "Rua B, 789", "dr.silva@email.com", "CRM-12345", Especialidade.cardiologia);
        
        Consulta consulta1 = new Consulta(LocalDate.of(2024, 3, 5), LocalTime.of(14, 30), "Consulta de rotina", medico1, tutor1, animal1);
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        List<Animal> animais = new ArrayList<>();
        animais.add(animal1);
        animais.add(animal2);
        animais.add(animal3);
        animais.add(animal4);
        animais.add(animal5);
        animais.add(animal6);


        while (opcao != 8) {
            System.out.println("=== MENU ===");
            System.out.println("1 - Pessoas");
            System.out.println("2 - Tutor");
            System.out.println("3 - Medico");
            System.out.println("4 - Consulta");
            System.out.println("5 - Animal");
            System.out.println("6 - Comparar pessoas");
            System.out.println("7 - Listar animais");
            System.out.println("8 - Sair");
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
                    System.out.println("\n" + tutores + "\n");
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
                    System.out.println("\nTamanho Lista Animais: " + animais.size() + "\n" );

                    /*System.out.println("\n" + "Percorrendo lista com for padrão"  + "\n" );

                    for (int i=0; i<animais.size(); i++) {
                        if(animais.get(i).getId() == 1) {
                            animais.remove(i);
                        }
                        System.out.println(animais.get(i));
                    }*/


                    System.out.println("\n" + "Percorrendo lista com foreach"  + "\n" );

                    for (Animal animal : animais) {
                        System.out.println(animal);
                    }

                    System.out.println("\n" + "Percorrendo lista com iterator"  + "\n" );

                    Iterator<Animal> iterator = animais.iterator();
                    while(iterator.hasNext()) {
                        Animal animal = iterator.next();
                        System.out.println(animal);
                    }

                    /*System.out.println("\n" + "Removendo animal com id 1"  + "\n" );
                    animais.remove(animal1);
                    System.out.println(animais); */

                    System.out.println("\n" + "Contem animal: " + animais.contains(animal1)  + "\n" );
                    System.out.println("\n" + "Lista é vazia: " + animais.isEmpty()  + "\n" );
                    System.out.println("\n" + "Index do animal1: " + animais.indexOf(animal1)  + "\n" );
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!\n");
            }
        }

        scanner.close();
    }
}