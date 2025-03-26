package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Atividade")
public class Atividade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "idCuidador", unique = true, nullable = false)
    private Cuidador cuidador;

    @OneToOne
    @JoinColumn(name = "idPaciente", unique = true, nullable = false)
    private Paciente paciente;

    @ManyToOne // Cada atividade pertence a um relatório
    @JoinColumn(name = "id_relatorio", nullable = true)  // Relatório ainda pode ser nulo inicialmente
    private Relatorio relatorio;

    @Column(unique = true, nullable = false)
    private String dataHora;

    @Column(nullable = false)
    private String descricao;

    public Atividade() {

    }

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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}