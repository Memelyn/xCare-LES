package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "item_medico")
public class ItemMedico implements Serializable {
    @Id
    private Integer registroAnvisa;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private String tipoUnidade;

    public Integer getRegistroAnvisa() {
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

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }
}