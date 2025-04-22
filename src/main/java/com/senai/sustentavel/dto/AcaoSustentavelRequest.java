package com.senai.sustentavel.dto;


import com.senai.sustentavel.model.CategoriaAcao;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AcaoSustentavelRequest {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, max = 500, message = "A descrição deve ter entre 10 e 500 caracteres")
    private String descricao;

    @NotNull(message = "A categoria é obrigatória")
    private CategoriaAcao categoria;

    @NotNull(message = "A data de realização é obrigatória")
    @PastOrPresent(message = "A data de realização não pode ser no futuro")
    private LocalDate dataRealizacao;

    @NotBlank(message = "O responsável é obrigatório")
    @Size(max = 100, message = "O nome do responsável deve ter no máximo 100 caracteres")
    private String responsavel;

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