package aula02_05mar;

import java.time.LocalDate;

public class Medico extends Pessoa{
    private String crm;
    private Especialidade especialidade;

    public Medico(int id, String nome, LocalDate dataNascimento, String endereco, String email, String crm, Especialidade especialidade) {
        super(id, nome, dataNascimento, endereco, email);
        this.crm = crm;
        this.especialidade = especialidade;
    }
    

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico = " +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", endereco='" + getEndereco() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade='" + especialidade + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medico medico = (Medico) o;

        return crm.equals(medico.crm);
    }

    @Override
    public int hashCode() {
        return crm.hashCode();


    }
}