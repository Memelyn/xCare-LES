package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "endereco_medicamento")
public class EnderecoMedicamento implements Serializable {

    @EmbeddedId
    private EnderecoMedicamentoId id;

    @ManyToOne
    @JoinColumn(name = "registro_anvisa_medicamento", referencedColumnName = "registro_anvisa_medicamento", insertable = false, updatable = false)
    private Medicamento medicamento;

    @ManyToOne
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", insertable = false, updatable = false)
    private Endereco endereco;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer quantidade;

    // Getters e setters
    public EnderecoMedicamentoId getId() {
        return id;
    }

    public void setId(EnderecoMedicamentoId id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
