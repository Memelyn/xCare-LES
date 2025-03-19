package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "medicamento_paciente")
public class MedicamentoPaciente implements Serializable {
    @OneToOne
    @Id
    @JoinColumn(name = "registro_anvisa_medicamento", unique = true, nullable = false)
    private Medicamento medicamento;

    @OneToOne
    @Id
    @JoinColumn(name = "id_paciente", unique = true, nullable = false)
    private Paciente paciente;  

    @Id
    private LocalTime horario;

    @Column(nullable = false)
    private Integer quantia_dose;

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

    public Integer getQuantia_dose() {
        return quantia_dose;
    }

    public void setQuantia_dose(Integer quantia_dose) {
        this.quantia_dose = quantia_dose;
    }
}
