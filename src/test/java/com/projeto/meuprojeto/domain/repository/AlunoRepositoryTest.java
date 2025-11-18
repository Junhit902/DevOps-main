package com.projeto.meuprojeto.domain.repository;

import com.projeto.meuprojeto.domain.entities.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class AlunoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    void deveSalvarERecuperarAluno() {
        Aluno aluno = Aluno.builder()
                .nome("Maria")
                .cursosConcluidos(4)
                .mediaGlobal(9.0)
                .build();

        entityManager.persist(aluno);
        entityManager.flush();

        List<Aluno> encontrados = alunoRepository.findAll();
        assertFalse(encontrados.isEmpty());
    }
}
