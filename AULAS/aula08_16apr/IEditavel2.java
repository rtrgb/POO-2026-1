package aula08_16apr;

public interface IEditavel2 extends IEditavel {

    static String darEnfase(String conteudo) {
        return new String(enfatizar(conteudo));
    }

    private static String enfatizar(String conteudo) {
        conteudo = conteudo.toUpperCase();
        String novoConteudo = "### " + conteudo + " ###";
        return novoConteudo;
    }

    public void anexar (String conteudo);

}
