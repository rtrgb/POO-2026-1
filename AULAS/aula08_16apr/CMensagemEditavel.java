package aula08_16apr;

public class CMensagemEditavel extends AMensagem implements IImprimivel, IEditavel {

    public CMensagemEditavel(String conteudo) {
        super(conteudo);
    }

    public void imprimir() {
       imprimirNoConsole();
    }

    public void imprimirNoConsole() {
        System.out.println(IImprimivel.INICIO + getConteudo() + IImprimivel.FIM);
    }

    public void editar(String conteudo) {
        setConteudo(conteudo);
    }
}
