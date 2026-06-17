package aula02_05mar;

import java.time.LocalDate;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class Tutor extends Pessoa {

    private String profissao;
    private int diaPagamento;
    private List<Animal> animais = new ArrayList<>();
    
    public Tutor(int id, String nome, LocalDate dataNascimento, String endereco, String email, String profissao, int diaPagamento){
        super(id, nome, dataNascimento, endereco, email);
        this.profissao = profissao;
        this.diaPagamento = diaPagamento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public boolean adicionarAnimal(Animal animal) {
        return this.animais.add(animal);
    }

    public boolean removerAnimal(Animal animal) {
        return this.animais.remove(animal);
    }

    public boolean removerAnimalPorId(int id) {
        Iterator<Animal> iterator = this.animais.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tutor other = (Tutor) obj;
        return getId() == other.getId() && Objects.equals(getNome(), other.getNome());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId(),getNome());
    }


    @Override
    public String toString() {
        return "Tutor = " + getId() +
                ",\n nome='" + getNome() +
                ",\n dataNascimento=" + getDataNascimento() +
                ",\n endereco='" + getEndereco() +
                ",\n email='" + getEmail() +
                ",\n profissao='" + profissao +
                ",\n diaPagamento=" + diaPagamento +
                ",\n\n animais= \n\n" + animais + 
                '}' + "\n\n";
    }

}