package com.xCare.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnderecoItemMedicoId implements Serializable {

    private Long idEndereco;
    private Long IditemMedico;

    public EnderecoItemMedicoId(Long idEndereco, Long IditemMedico) {
        this.idEndereco = idEndereco;
        this.IditemMedico = IditemMedico;
    }

    // Getters e setters

    public Long getEndereco() {
        return idEndereco;
    }

    public void setEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Long getItemMedico() {
        return IditemMedico;
    }

    public void setItemMedico(Long IditemMedico) {
        this.IditemMedico = IditemMedico;
    }

    // hashCode() e equals() para comparar as chaves compostas corretamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoItemMedicoId that = (EnderecoItemMedicoId) o;
        return Objects.equals(idEndereco, that.idEndereco) && Objects.equals(IditemMedico, that.IditemMedico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco, IditemMedico);
    }
}
