package com.xCare.model;

import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.io.Serializable;

@Embeddable
public class EnderecoMedicamentoId implements Serializable {

    private Long idMedicamento;
    private Long idEndereco;

    public EnderecoMedicamentoId() {
    }

    public EnderecoMedicamentoId(Long idEndereco, Long idMedicamento) {
        this.idEndereco = idEndereco;
        this.idMedicamento = idMedicamento;
    }

    // Getters e setters
    public Long getMedicamento() {
        return idMedicamento;
    }

    public void setMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Long getEndereco() {
        return idEndereco;
    }

    public void setEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoMedicamentoId that = (EnderecoMedicamentoId) o;
        return idMedicamento.equals(that.idMedicamento) && idEndereco.equals(that.idEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedicamento, idEndereco);
    }
}
