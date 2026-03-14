package aula03_12mar;

public class Editora {
    private int id;
    private String nome;
    private String cidade;

    public Editora(int id, String nome, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Editora other = (Editora) obj;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Editora = " + getId() +
                ",\n nome='" + getNome() + '\'' +
                ",\n cidade='" + getCidade() + '\'' +
                '}' + "\n\n";
    }
}
