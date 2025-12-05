package com.projeto.meuprojeto.application.service;

import com.projeto.meuprojeto.application.dto.AlunoDTO;
import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.repository.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @Test
    void deveSalvarAluno() {
        Aluno aluno = Aluno.builder()
                .id(1L)
                .nome("Joao")
                .cursosConcluidos(3)
                .mediaGlobal(8.0)
                .build();

        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        AlunoDTO dto = AlunoDTO.builder()
                .nome("Joao")
                .cursosConcluidos(3)
                .mediaGlobal(8.0)
                .build();

        AlunoDTO salvo = alunoService.salvar(dto);
        assertNotNull(salvo.getId());
    }

    @Test
    void deveListarTodosAlunos() {
        Aluno aluno1 = Aluno.builder()
                .id(1L)
                .nome("Joao")
                .cursosConcluidos(3)
                .mediaGlobal(8.0)
                .build();

        Aluno aluno2 = Aluno.builder()
                .id(2L)
                .nome("Maria")
                .cursosConcluidos(2)
                .mediaGlobal(9.0)
                .build();

        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));

        List<AlunoDTO> alunos = alunoService.listarTodos();

        assertEquals(2, alunos.size());
        assertEquals("Joao", alunos.get(0).getNome());
        assertEquals("Maria", alunos.get(1).getNome());
    }

    @Test
    void deveBuscarAlunoPorId() {
        Aluno aluno = Aluno.builder()
                .id(1L)
                .nome("Joao")
                .cursosConcluidos(3)
                .mediaGlobal(8.0)
                .build();

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        AlunoDTO dto = alunoService.buscarPorId(1L);

        assertEquals(1L, dto.getId());
        assertEquals("Joao", dto.getNome());
    }

    @Test
    void deveLancarExcecaoQuandoAlunoNaoEncontrado() {
        when(alunoRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> alunoService.buscarPorId(99L));

        assertEquals("Aluno não encontrado", exception.getMessage());
    }
}
