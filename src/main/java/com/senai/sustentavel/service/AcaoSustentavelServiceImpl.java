package com.senai.sustentavel.service;

import com.senai.sustentavel.dto.AcaoSustentavelRequest;
import com.senai.sustentavel.dto.AcaoSustentavelResponse;
import com.senai.sustentavel.model.AcaoSustentavel;
import com.senai.sustentavel.repository.AcaoSustentavelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AcaoSustentavelServiceImpl implements AcaoSustentavelService {

    private final AcaoSustentavelRepository repository;

    public AcaoSustentavelServiceImpl(AcaoSustentavelRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcaoSustentavelResponse criar(AcaoSustentavelRequest request) {
        AcaoSustentavel acao = new AcaoSustentavel();
        acao.setTitulo(request.getTitulo());
        acao.setDescricao(request.getDescricao());
        acao.setCategoria(request.getCategoria());
        acao.setDataRealizacao(request.getDataRealizacao());
        acao.setResponsavel(request.getResponsavel());

        AcaoSustentavel salva = repository.save(acao);

        return new AcaoSustentavelResponse(
                salva.getId(), salva.getTitulo(), salva.getDescricao(),
                salva.getCategoria(), salva.getDataRealizacao(), salva.getResponsavel()
        );
    }

    @Override
    public List<AcaoSustentavelResponse> listarTodas() {
        return repository.findAll()
                .stream()
                .map(acao -> new AcaoSustentavelResponse(
                        acao.getId(), acao.getTitulo(), acao.getDescricao(),
                        acao.getCategoria(), acao.getDataRealizacao(), acao.getResponsavel()))
                .collect(Collectors.toList());
    }

    @Override
    public AcaoSustentavelResponse buscarPorId(Long id) {
        Optional<AcaoSustentavel> acao = repository.findById(id);
        return acao.map(a -> new AcaoSustentavelResponse(
                        a.getId(), a.getTitulo(), a.getDescricao(), a.getCategoria(), a.getDataRealizacao(), a.getResponsavel()))
                .orElse(null);
    }

    @Override
    public AcaoSustentavelResponse atualizar(Long id, AcaoSustentavelRequest request) {
        Optional<AcaoSustentavel> acaoOptional = repository.findById(id);
        if (acaoOptional.isPresent()) {
            AcaoSustentavel acao = acaoOptional.get();
            acao.setTitulo(request.getTitulo());
            acao.setDescricao(request.getDescricao());
            acao.setCategoria(request.getCategoria());
            acao.setDataRealizacao(request.getDataRealizacao());
            acao.setResponsavel(request.getResponsavel());

            AcaoSustentavel salva = repository.save(acao);

            return new AcaoSustentavelResponse(
                    salva.getId(), salva.getTitulo(), salva.getDescricao(),
                    salva.getCategoria(), salva.getDataRealizacao(), salva.getResponsavel()
            );
        }
        return null; // Retorna null se não encontrar a ação
    }

    @Override
    public boolean excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}