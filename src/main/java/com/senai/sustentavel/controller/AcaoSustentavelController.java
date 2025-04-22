package com.senai.sustentavel.controller;

import com.senai.sustentavel.dto.AcaoSustentavelRequest;
import com.senai.sustentavel.dto.AcaoSustentavelResponse;
import com.senai.sustentavel.exception.RecursoNaoEncontradoException;
import com.senai.sustentavel.service.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class AcaoSustentavelController {

    private final AcaoSustentavelService service;

    public AcaoSustentavelController(AcaoSustentavelService service) {
        this.service = service;
    }

    @GetMapping
    public List<AcaoSustentavelResponse> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> buscarPorId(@PathVariable Long id) {
        AcaoSustentavelResponse acao = service.buscarPorId(id);
        if (acao == null) {
            throw new RecursoNaoEncontradoException("Ação sustentável não encontrada com o ID: " + id);
        }
        return ResponseEntity.ok(acao);
    }

    @PostMapping
    public ResponseEntity<AcaoSustentavelResponse> cadastrar(@RequestBody @Valid AcaoSustentavelRequest request) {
        AcaoSustentavelResponse novaAcao = service.criar(request);
        return ResponseEntity.status(201).body(novaAcao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AcaoSustentavelRequest request) {
        AcaoSustentavelResponse acaoAtualizada = service.atualizar(id, request);
        if (acaoAtualizada == null) {
            throw new RecursoNaoEncontradoException("Ação sustentável não encontrada para atualização com o ID: " + id);
        }
        return ResponseEntity.ok(acaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean excluida = service.excluir(id);
        if (!excluida) {
            throw new RecursoNaoEncontradoException("Ação sustentável não encontrada para exclusão com o ID: " + id);
        }
        return ResponseEntity.noContent().build();
    }
}