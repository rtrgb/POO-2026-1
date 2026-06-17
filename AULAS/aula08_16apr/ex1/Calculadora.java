package aula08_16apr.ex1;

public class Calculadora implements CalculadoraBasica, CalculadoraAvancada {

    //basica

    public void adicionar(double a, double b) {
        System.out.println("Adição: " + (a+b));
    }

    public void subtrair(double a, double b) {
        System.out.println("Subtração: " + (a-b));
    }

    public void multiplicar(double a, double b) {
        System.out.println("Multiplicação: " + (a * b));
    }

    public void dividir(double a, double b) {
        System.out.println("Divisão: " + (a / b));
    }

    //avancada

    public void areacirculo(double raio) {
        System.out.println("Raio: " + (CONSTANTEPI * raio * raio));
    }

    public void circuncirculo(double raio) {
        System.out.println("Circunferência: " + (2 * CONSTANTEPI * raio));
    }

    public void potencia(double base, double expoente) {
        System.out.println("Potência: " + Math.pow(base, expoente));
    }

    public void sqr(double numero) {
        System.out.println("Square root: " + Math.sqrt(numero));
    }
}


