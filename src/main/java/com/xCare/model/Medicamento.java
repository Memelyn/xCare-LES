package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "medicamento")
public class Medicamento implements Serializable {
    @Id
    private long registroAnvisa;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    public long getRegistroAnvisa() {
        return registroAnvisa;
    }

    public void setRegistroAnvisa(Integer registroAnvisa) {
        this.registroAnvisa = registroAnvisa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}