package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "medicamento_endereco")
public class MedicamentoEndereco implements Serializable {

    @OneToOne
    @Id
    @JoinColumn(name = "registro_anvisa_medicamento", unique = true, nullable = false)
    private Medicamento medicamento;

    @OneToOne
    @Id
    @JoinColumn(name = "id_endereco", unique = true, nullable = false)
    private Endereco endereco;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer quantidade;

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
