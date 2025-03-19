package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "item_medico_endereco")
public class ItemMedicoEndereco implements Serializable {

    @OneToOne
    @Id
    @JoinColumn(name = "registro_anvisa_item_medico", unique = true, nullable = false)
    private ItemMedico itemMedico;

    @OneToOne
    @Id
    @JoinColumn(name = "id_endereco", unique = true, nullable = false)
    private Endereco endereco;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer quantidade;

    public ItemMedico getItemMedico() {
        return itemMedico;
    }

    public void set(ItemMedico itemMedico) {
        this.itemMedico = itemMedico;
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
