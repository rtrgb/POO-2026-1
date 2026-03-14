package aula03_12mar;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private int id;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevoldida;
    private statusEmprestimo statusEmprestimo;

public Emprestimo(int id, LocalDate dataEmprestimo, LocalDate dataDevolucao, LocalDate dataDevoldida, statusEmprestimo statusEmprestimo) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataDevoldida = dataDevoldida;
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

    public LocalDate getDataDevoldida() {
        return dataDevoldida;
    }

    public void setDataDevoldida(LocalDate dataDevoldida) {
        this.dataDevoldida = dataDevoldida;
    }

    public statusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(statusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
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
                ",\n dataDevoldida=" + getDataDevoldida() +
                ",\n statusEmprestimo=" + getStatusEmprestimo() +
                '}' + "\n\n";
    }

}
