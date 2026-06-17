package aula08_16apr.ex1;

public interface CalculadoraAvancada {
    public static final double CONSTANTEPI = 3.14;

    public abstract void areacirculo(double raio);
    public abstract void circuncirculo(double raio);
    public abstract void potencia(double base, double expoente);
    public abstract void sqr(double numero);
}
