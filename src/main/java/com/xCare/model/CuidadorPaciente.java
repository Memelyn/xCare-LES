package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Cuidador_paciente")
public class CuidadorPaciente implements Serializable {

    @EmbeddedId
    private CuidadorPacienteId id;

    @ManyToOne
    @JoinColumn(name = "idCuidador", referencedColumnName = "id", insertable = false, updatable = false)
    private Cuidador cuidador;

    @ManyToOne
    @JoinColumn(name = "idPaciente", referencedColumnName = "id", insertable = false, updatable = false)
    private Paciente paciente;

    public CuidadorPaciente() {

    }


    // Getters e setters
    public CuidadorPacienteId getId() {
        return id;
    }

    public void setId(CuidadorPacienteId id) {
        this.id = id;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
