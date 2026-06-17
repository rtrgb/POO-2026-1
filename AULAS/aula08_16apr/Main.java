package aula08_16apr;

public class Main {
    public static void main(String[] args) {

        CMensagemImprimivel m1 = new CMensagemImprimivel("Interfaces são legais!");
        m1.imprimir();

        CMensagemEditavel m2 = new CMensagemEditavel("Java 15");
        m2.limpar();
        m2.editar("Não era Java 15...");
        m2.imprimir();

        System.out.println(IEditavel2.darEnfase("Hoje tem prova!"));

    }
}
