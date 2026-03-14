package aula03_12mar;

public class Genero {
    private int id;
    private String descricao;

    public Genero(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Genero other = (Genero) obj;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Genero = " + getId() +
                ",\n descricao='" + getDescricao() + '\'' +
                '}' + "\n\n";
    }

}
