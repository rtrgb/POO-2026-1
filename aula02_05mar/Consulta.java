package aula02_05mar;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private String registro;
    private LocalDate data;
    private LocalTime hora;
    private String motivo;
    private Medico medico;
    private Tutor tutor;
    private Animal animal;

    public Consulta(LocalDate data, LocalTime hora, String motivo, Medico medico, Tutor tutor, Animal animal) {
        this.data = data;
        this.hora = hora;
        this.motivo = motivo;
        this.medico = medico;
        this.tutor = tutor;
        this.animal = animal;
        this.registro = animal.getNome() + "_" + data + "_" + tutor.getNome();
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public LocalDate getData() {
        return data;
    }       

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }   

    public Tutor getTutor() {
        return tutor;
    }   

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    @Override
    public String toString() {
        return "Consulta = " +
                "registro='" + registro + '\'' +
                ", data=" + data +
                ", hora=" + hora +
                ", motivo='" + motivo + '\'' +
                ", medico=" + medico.getNome() +
                ", tutor=" + tutor.getNome() +
                ", animal=" + animal.getNome();
    }

    @Override
   public int hashCode() {
        return registro.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consulta consulta = (Consulta) o;

        return registro.equals(consulta.registro);
    }

    

}
