package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Endereco_item_medico")
public class EnderecoItemMedico implements Serializable {

    @EmbeddedId
    private EnderecoItemMedicoId id;

    @ManyToOne
    @JoinColumn(name = "registro_anvisa_item_medico", referencedColumnName = "registroAnvisa", insertable = false, updatable = false)
    private ItemMedico itemMedico;

    @ManyToOne
    @JoinColumn(name = "idEndereco", referencedColumnName = "id", insertable = false, updatable = false)
    private Endereco endereco;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer quantidade;

    // Construtor
    public EnderecoItemMedico() {

    }

    // Getters e setters

    public EnderecoItemMedicoId getId() {
        return id;
    }

    public void setId(EnderecoItemMedicoId id) {
        this.id = id;
    }

    public ItemMedico getItemMedico() {
        return itemMedico;
    }

    public void setItemMedico(ItemMedico itemMedico) {
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
