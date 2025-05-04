package com.senai.sustentavel.entity;

import com.senai.sustentavel.Categoria;
import jakarta.persistence.*;

@Entity
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

}