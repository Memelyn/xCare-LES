package com.xCare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cuidador")
public class Cuidador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 80)
    private Integer idade;

    @Column(nullable = false, length = 80)
    private String sexo;

    @Column(nullable = false, length = 80)
    private String dataNascimento;

    @Column(unique = true, nullable = false, length = 80)
    private String cpf;

    @Column(unique = true, nullable = false, length = 80)
    private String telefone;

    @Column(unique = true, nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 80)
    private String empresa;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(length = 50)
    private String especializacao;
}
