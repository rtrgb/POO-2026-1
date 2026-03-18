package aula03_12mar;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private int id;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolvida;
    private statusEmprestimo statusEmprestimo;
    private Socio socio;
    private Livro livro;

public Emprestimo(int id, LocalDate dataEmprestimo, LocalDate dataDevolucao, LocalDate dataDevolvida, statusEmprestimo statusEmprestimo) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolvida = dataDevolvida;
        this.statusEmprestimo = statusEmprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataDevolvida() {
        return dataDevolvida;
    }

    public void setDataDevolvida(LocalDate dataDevolvida) {
        this.dataDevolvida = dataDevolvida;
    }

    public statusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(statusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    } 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Emprestimo other = (Emprestimo) obj;
        return getId() == other.getId() && Objects.equals(getDataEmprestimo(), other.getDataEmprestimo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataEmprestimo());
    }

        @Override
        public String toString() {
            return "Emprestimo = " + getId() +
            ",\n dataEmprestimo=" + getDataEmprestimo() +
            ",\n dataDevolucao=" + getDataDevolucao() +
            ",\n dataDevolvida=" + getDataDevolvida() +
            ",\n statusEmprestimo=" + getStatusEmprestimo() +
            ",\n socio=" + (socio != null ? socio.getNome() : "não informado") +
            ",\n livro=" + (livro != null ? livro.getTitulo() : "não informado") +
            '}' + "\n\n";
        }
    

}
