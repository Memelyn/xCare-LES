package com.xCare.model;

import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.io.Serializable;

@Embeddable
public class PacienteMedicamentoId implements Serializable {

    private Long idMedicamento;
    private Long idPaciente;

    // Construtor
    public PacienteMedicamentoId() {
    }

    // Construtor com parametros
    public PacienteMedicamentoId(Long idMedicamento, Long idPaciente) {
        this.idMedicamento = idMedicamento;
        this.idPaciente = idPaciente;
    }

    // Getters e setters
    public Long getMedicamento() {
        return idMedicamento;
    }

    public void setMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Long getPaciente() {
        return idPaciente;
    }

    public void setPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteMedicamentoId that = (PacienteMedicamentoId) o;
        return idMedicamento.equals(that.idMedicamento) && idPaciente.equals(that.idPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedicamento, idPaciente);
    }
}
