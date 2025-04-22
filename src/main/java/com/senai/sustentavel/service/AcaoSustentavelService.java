package com.senai.sustentavel.service;

import com.senai.sustentavel.dto.AcaoSustentavelRequest;
import com.senai.sustentavel.dto.AcaoSustentavelResponse;

import java.util.List;

public interface AcaoSustentavelService {

    AcaoSustentavelResponse criar(AcaoSustentavelRequest request);

    List<AcaoSustentavelResponse> listarTodas();

    AcaoSustentavelResponse buscarPorId(Long id);

    AcaoSustentavelResponse atualizar(Long id, AcaoSustentavelRequest request);

    boolean excluir(Long id);
}