package com.senai.sustentavel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

    @Entity
    public class AcaoSustentavel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "O título é obrigatório")
        private String titulo;

        @NotBlank(message = "A descrição é obrigatória")
        private String descricao;

        @Enumerated(EnumType.STRING)
        @NotNull(message = "A categoria é obrigatória")
        private CategoriaAcao categoria;

        @NotNull(message = "A data de realização é obrigatória")
        private LocalDate dataRealizacao;

        @NotBlank(message = "O responsável é obrigatório")
        private String responsavel;

        // Getters e Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitulo() { return titulo; }
        public void setTitulo(String titulo) { this.titulo = titulo; }

        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }

        public CategoriaAcao getCategoria() { return categoria; }
        public void setCategoria(CategoriaAcao categoria) { this.categoria = categoria; }

        public LocalDate getDataRealizacao() { return dataRealizacao; }
        public void setDataRealizacao(LocalDate dataRealizacao) { this.dataRealizacao = dataRealizacao; }

        public String getResponsavel() { return responsavel; }
        public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    }

