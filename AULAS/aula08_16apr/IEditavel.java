package aula08_16apr;

public interface IEditavel {

    long chave = 0xABDCEF0;

    public abstract void editar(String conteudo);

    default void limpar(){
        editar("");
    }

}
