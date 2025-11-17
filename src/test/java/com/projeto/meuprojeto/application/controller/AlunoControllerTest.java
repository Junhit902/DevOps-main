package com.projeto.meuprojeto.application.controller;

import com.projeto.meuprojeto.application.dto.AlunoDTO;
import com.projeto.meuprojeto.application.service.AlunoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AlunoController.class)
class AlunoControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private AlunoService alunoService;

        @Test
        void deveCriarAluno() throws Exception {
                AlunoDTO dto = AlunoDTO.builder()
                                .id(1L)
                                .nome("Joao")
                                .cursosConcluidos(3)
                                .mediaGlobal(8.0)
                                .build();

                when(alunoService.salvar(any(AlunoDTO.class))).thenReturn(dto);

                String json = """
                                {
                                  "nome": "Joao",
                                  "cursosConcluidos": 3,
                                  "mediaGlobal": 8.0
                                }
                                """;

                mockMvc.perform(post("/alunos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.id").value(1L));
        }

        @Test
        void deveListarAlunos() throws Exception {
                AlunoDTO dto = AlunoDTO.builder()
                                .id(1L)
                                .nome("Joao")
                                .cursosConcluidos(3)
                                .mediaGlobal(8.0)
                                .build();

                when(alunoService.listarTodos()).thenReturn(Collections.singletonList(dto));

                mockMvc.perform(get("/alunos")
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[0].id").value(1L));
        }

        @Test
        void deveBuscarAlunoPorId() throws Exception {
                AlunoDTO dto = AlunoDTO.builder()
                                .id(1L)
                                .nome("Joao")
                                .cursosConcluidos(3)
                                .mediaGlobal(8.0)
                                .build();

                when(alunoService.buscarPorId(eq(1L))).thenReturn(dto);

                mockMvc.perform(get("/alunos/1")
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.id").value(1L));
        }
}
