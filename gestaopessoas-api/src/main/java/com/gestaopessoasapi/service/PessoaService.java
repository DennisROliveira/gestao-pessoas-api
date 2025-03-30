package com.gestaopessoasapi.service;

import com.gestaopessoasapi.model.Pessoa;
import com.gestaopessoasapi.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository repository;
    
    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }
    

    public Pessoa criar(Pessoa pessoa) {
        return repository.save(pessoa);
    }
    

    public List<Pessoa> listar() {
        return repository.findAll();
    }
    

    public Pessoa buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
    }
    
@Transactional
public Pessoa atualizar(Long id, Pessoa novaPessoa) {
    try {
        Pessoa pessoa = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        pessoa.setNome(novaPessoa.getNome());
        pessoa.setCpf(novaPessoa.getCpf());
        pessoa.setEmail(novaPessoa.getEmail());

        return repository.save(pessoa);
    } catch (EntityNotFoundException ex) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada", ex);
    } catch (Exception ex) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor", ex);
    }
}
    

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
