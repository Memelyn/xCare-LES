package com.xCare.model;

import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "Relatorio")
public class Relatorio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "idCuidador", unique = true, nullable = false)
    private Cuidador cuidador;

    @OneToMany(mappedBy = "relatorio")
    private List<Atividade> atividades;

    @OneToOne
    @JoinColumn(name = "idPaciente", unique = true, nullable = false)
    private Paciente paciente;

    private String dataInicio;

    private String dataFim;

    private String observacoes;

    public Relatorio() {

    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}