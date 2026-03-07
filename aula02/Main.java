package aula02;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        //pessoa
        Pessoa pessoa1 = new Pessoa(1, "Gabriel", LocalDate.of(2006, 2, 16), "Rua A, 123", "gabriel@email.com");
        System.out.println("\n" + pessoa1 + "\n");
        System.out.println("Idade pessoa 1: " +pessoa1.calcularIdade() + "\n");
        System.out.println("hashcode pessoa 1: " + pessoa1.hashCode() + "\n");

        Pessoa pessoa2 = new Pessoa(2, "Mariana", LocalDate.of(2005, 5, 25), "Rua A, 456", "jorge@email.com");
        System.out.println(pessoa2 + "\n");
        System.out.println("Idade pessoa 2: " +pessoa2.calcularIdade() + "\n");
        System.out.println("hashcode pessoa 2: " + pessoa2.hashCode() + "\n");


        System.out.println("Pessoas iguais? " + pessoa1.equals(pessoa2) + "\n");

        System.out.println("------------------------\n");

        //tutor
        Tutor tutor1 = new Tutor(2, "Gabriel", LocalDate.of(2006, 2, 16), "Rua A, 123", "gabriel@email.com", "Professor", 15);
        System.out.println(tutor1 + "\n");

        System.out.println("------------------------\n");

        //medico
        Medico medico1 = new Medico(3, "Dr. Silva", LocalDate.of(1980, 10, 5), "Rua B, 789", "dr.silva@email.com", "CRM-12345", Especialidade.cardiologia);
        System.out.println(medico1 + "\n");

        System.out.println("------------------------\n");


}

}