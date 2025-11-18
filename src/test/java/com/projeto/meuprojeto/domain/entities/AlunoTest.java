package com.projeto.meuprojeto.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @Test
    void deveUtilizarConstrutorCompletoEGeradoresLombok() {
        Aluno aluno = new Aluno(1L, "Maria", 5, 9.0);

        assertEquals(1L, aluno.getId());
        assertEquals("Maria", aluno.getNome());
        assertEquals(5, aluno.getCursosConcluidos());
        assertEquals(9.0, aluno.getMediaGlobal());

        aluno.setNome("Ana");
        aluno.setCursosConcluidos(4);
        aluno.setMediaGlobal(8.0);

        assertEquals("Ana", aluno.getNome());
        assertEquals(4, aluno.getCursosConcluidos());
        assertEquals(8.0, aluno.getMediaGlobal());

        assertNotNull(aluno.toString());
    }

    @Test
    void equalsEHashCodeDevemUsarApenasId() {
        Aluno aluno1 = Aluno.builder()
                .id(1L)
                .nome("Joao")
                .cursosConcluidos(3)
                .mediaGlobal(8.5)
                .build();

        Aluno aluno2 = Aluno.builder()
                .id(1L)
                .nome("Outro Nome")
                .cursosConcluidos(10)
                .mediaGlobal(5.0)
                .build();

        Aluno aluno3 = Aluno.builder()
                .id(2L)
                .nome("Joao")
                .cursosConcluidos(3)
                .mediaGlobal(8.5)
                .build();

        assertEquals(aluno1, aluno2);
        assertEquals(aluno1.hashCode(), aluno2.hashCode());
        assertNotEquals(aluno1, aluno3);
    }
}
