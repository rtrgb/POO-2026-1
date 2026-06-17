package aula08_16apr;

public class CMensagemImprimivel extends AMensagem implements IImprimivel {

    public CMensagemImprimivel(String conteudo) {
        super(conteudo);
    }

    public void imprimir() {
        imprimirNoConsole();
    }

    public void imprimirNoConsole() {
        System.out.println(IImprimivel.INICIO);
        System.out.println(getConteudo());
        System.out.println(IImprimivel.FIM);
    }

}