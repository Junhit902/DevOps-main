package com.projeto.meuprojeto.application.service;

import com.projeto.meuprojeto.application.dto.AlunoDTO;
import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.repository.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
}
