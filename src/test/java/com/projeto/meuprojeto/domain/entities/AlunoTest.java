package com.projeto.meuprojeto.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlunoTest {

    @Test
    void deveCriarAlunoComDadosValidos() {
        Aluno aluno = Aluno.builder()
                .nome("Joao")
                .cursosConcluidos(3)
                .mediaGlobal(8.5)
                .build();

        assertEquals("Joao", aluno.getNome());
        assertEquals(3, aluno.getCursosConcluidos());
        assertEquals(8.5, aluno.getMediaGlobal());
    }
}
