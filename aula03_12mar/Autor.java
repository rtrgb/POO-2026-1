package aula03_12mar;

public class Autor {
    private int id;
    private String nome;

    public Autor(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Autor other = (Autor) obj;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Autor = " + getId() +
                ",\n nome='" + getNome() + '\'' +
                '}' + "\n\n";
    }
}
