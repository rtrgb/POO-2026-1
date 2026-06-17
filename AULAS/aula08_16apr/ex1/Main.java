package aula08_16apr.ex1;

import java.util.Scanner;

public class Main {

    /* 
    public static void main(String[] args) {

        Calculadora c1 = new Calculadora();

        c1.adicionar(10,5);
        c1.subtrair(10,5);
        c1.multiplicar(10,5);
        c1.dividir(10,5);

        c1.areacirculo(7);
        c1.circuncirculo(7);
        c1.potencia(2,8);
        c1.sqr(25);
    }

*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("5 - Área do círculo");
            System.out.println("6 - Circunferência");
            System.out.println("7 - Potência");
            System.out.println("8 - Raiz quadrada");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("A: "); double a = sc.nextDouble();
                    System.out.print("B: "); double b = sc.nextDouble();
                    calc.adicionar(a, b); break;
                case 2:
                    System.out.print("A: "); a = sc.nextDouble();
                    System.out.print("B: "); b = sc.nextDouble();
                    calc.subtrair(a, b); break;
                case 3:
                    System.out.print("A: "); a = sc.nextDouble();
                    System.out.print("B: "); b = sc.nextDouble();
                    calc.multiplicar(a, b); break;
                case 4:
                    System.out.print("A: "); a = sc.nextDouble();
                    System.out.print("B: "); b = sc.nextDouble();
                    calc.dividir(a, b); break;
                case 5:
                    System.out.print("Raio: "); double r = sc.nextDouble();
                    calc.areacirculo(r); break;
                case 6:
                    System.out.print("Raio: "); r = sc.nextDouble();
                    calc.circuncirculo(r); break;
                case 7:
                    System.out.print("Base: "); double base = sc.nextDouble();
                    System.out.print("Expoente: "); double exp = sc.nextDouble();
                    calc.potencia(base, exp); break;
                case 8:
                    System.out.print("Número: "); double n = sc.nextDouble();
                    calc.sqr(n); break;
                case 0:
                    System.out.println("Saindo..."); break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}

