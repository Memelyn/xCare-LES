package com.xCare.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CuidadorPacienteId implements Serializable {

    private Long idCuidador;
    private Long idPaciente;

    // Construtor com parâmetros
    public CuidadorPacienteId(Long idCuidador, Long idPaciente) {
        this.idCuidador = idCuidador;
        this.idPaciente = idPaciente;
    }

    // Getters e setters
    public Long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(Long idCuidador) {
        this.idCuidador = idCuidador;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuidadorPacienteId that = (CuidadorPacienteId) o;
        return idCuidador.equals(that.idCuidador) && idPaciente.equals(that.idPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuidador, idPaciente);
    }
}
