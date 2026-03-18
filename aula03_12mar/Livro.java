package aula03_12mar;

import java.util.Objects;

public class Livro {
    private int id;
    private String titulo;
    private String anoLancamento;
    private int edicao;
    private int paginas;
    private String isbn;
    private Genero genero;
    private Autor autor;
    private Editora editora;
    

    public Livro(int id, String titulo, String anoLancamento, int edicao, int paginas, String isbn) {
    this.id = id;
    this.titulo = titulo;
    this.anoLancamento = anoLancamento;
    this.edicao = edicao;
    this.paginas = paginas;
    this.isbn = isbn;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro other = (Livro) obj;
        return getId() == other.getId() && Objects.equals(getIsbn(), other.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIsbn());
    }

    @Override
    public String toString() {
        return "Livro = " + getId() +
                ",\n titulo='" + getTitulo() + '\'' +
                ",\n anoLancamento='" + getAnoLancamento() + '\'' +
                ",\n edicao=" + getEdicao() +
                ",\n paginas=" + getPaginas() +
                ",\n isbn='" + getIsbn() + '\'' +
                '}' + "\n\n";
    }
}
