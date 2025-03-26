package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "paciente_medicamento")
public class PacienteMedicamento implements Serializable {

    @EmbeddedId
    private PacienteMedicamentoId id;

    @ManyToOne
    @JoinColumn(name = "registro_anvisa_medicamento", referencedColumnName = "registroAnvisa", insertable = false, updatable = false)
    private Medicamento medicamento;

    @ManyToOne
    @JoinColumn(name = "idPaciente", referencedColumnName = "id", insertable = false, updatable = false)
    private Paciente paciente;

    @Column(nullable = false)
    private LocalTime horario;

    @Column(nullable = false)
    private Integer quantiaDose;

    public PacienteMedicamento() {

    }

    // Getters e setters
    public PacienteMedicamentoId getId() {
        return id;
    }

    public void setId(PacienteMedicamentoId id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Integer getQuantiaDose() {
        return quantiaDose;
    }

    public void setQuantiaDose(Integer quantiaDose) {
        this.quantiaDose = quantiaDose;
    }
}
