package com.projeto.meuprojeto.domain.repository;

import com.projeto.meuprojeto.domain.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositório responsável pelo acesso aos dados da entidade Aluno.
 * Alteração simples de documentação, sem impacto no funcionamento.
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
