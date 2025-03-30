package com.gestaopessoasapi.controller;

import com.gestaopessoasapi.model.Pessoa;
import com.gestaopessoasapi.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    private MockMvc mockMvc;

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaController).build();
        pessoa = new Pessoa("Dennis", "12345678909", "dennis@email.com");
    }

    @Test
    public void testCriarPessoa() throws Exception {
        when(pessoaService.criar(any(Pessoa.class))).thenReturn(pessoa);

        mockMvc.perform(post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(pessoa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Dennis"));
        
        verify(pessoaService, times(1)).criar(any(Pessoa.class));
    }

    @Test
    public void testBuscarPessoaPorCpf() throws Exception {
        when(pessoaService.buscarPorCpf("12345678909")).thenReturn(pessoa);

        mockMvc.perform(get("/pessoas/cpf/12345678909"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Dennis"));
        
        verify(pessoaService, times(1)).buscarPorCpf("12345678909");
    }
}
