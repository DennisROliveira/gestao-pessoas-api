package com.gestaopessoasapi.controller;

import com.gestaopessoasapi.model.Pessoa;
import com.gestaopessoasapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "http://localhost:4200")  // Permitir requisições de "http://localhost:4200"
public class PessoaController {
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @Operation(summary = "Criar uma nova pessoa", description = "Cria uma nova pessoa com os dados fornecidos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pessoa criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(service.criar(pessoa));
    }

    @Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista de todas as pessoas cadastradas.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de pessoas retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @Operation(summary = "Buscar pessoa por CPF", description = "Retorna uma pessoa com o CPF fornecido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pessoa encontrada"),
        @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Pessoa> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.buscarPorCpf(cpf));
    }

    @Operation(summary = "Atualizar uma pessoa", description = "Atualiza os dados de uma pessoa existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(service.atualizar(id, pessoa));
    }

    @Operation(summary = "Deletar uma pessoa", description = "Remove uma pessoa pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pessoa deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
