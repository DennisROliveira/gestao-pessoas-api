package com.gestaopessoasapi.service;

import com.gestaopessoasapi.model.Pessoa;
import com.gestaopessoasapi.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
        pessoa = new Pessoa("Dennis", "12345678909", "dennis@email.com");
    }

    @Test
    public void testCriarPessoa() {
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa); // Mockando o repositório

        Pessoa pessoaCriada = pessoaService.criar(pessoa);
        
        assertNotNull(pessoaCriada); 
        assertEquals("Dennis", pessoaCriada.getNome()); 
        verify(pessoaRepository, times(1)).save(pessoa); 
    }

    @Test
    public void testBuscarPessoaPorCpf() {
        when(pessoaRepository.findByCpf("12345678909")).thenReturn(java.util.Optional.of(pessoa));

        Pessoa pessoaEncontrada = pessoaService.buscarPorCpf("12345678909");
        
        assertNotNull(pessoaEncontrada); // Verifica se a pessoa foi encontrada
        assertEquals("Dennis", pessoaEncontrada.getNome()); 
    }
}
