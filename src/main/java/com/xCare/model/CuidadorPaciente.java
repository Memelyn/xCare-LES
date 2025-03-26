package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Cuidador_paciente")
public class CuidadorPaciente implements Serializable {

    @EmbeddedId
    private CuidadorPacienteId id;

    @ManyToOne
    @JoinColumn(name = "id_cuidador", referencedColumnName = "id_cuidador", insertable = false, updatable = false)
    private Cuidador cuidador;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente", insertable = false, updatable = false)
    private Paciente paciente;

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
