package com.senai.sustentavel.repository;

import com.senai.sustentavel.Categoria;
import com.senai.sustentavel.model.AcaoSustentavel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
    List<AcaoSustentavel> findByCategoria(Categoria categoria);
}