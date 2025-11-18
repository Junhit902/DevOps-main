package com.projeto.meuprojeto.application.service;

import com.projeto.meuprojeto.application.dto.AlunoDTO;
import com.projeto.meuprojeto.domain.entities.Aluno;
import com.projeto.meuprojeto.domain.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoDTO salvar(AlunoDTO dto) {
        Aluno aluno = toEntity(dto);
        Aluno salvo = alunoRepository.save(aluno);
        return toDTO(salvo);
    }

    public List<AlunoDTO> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AlunoDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return toDTO(aluno);
    }

    private Aluno toEntity(AlunoDTO dto) {
        return Aluno.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .cursosConcluidos(dto.getCursosConcluidos())
                .mediaGlobal(dto.getMediaGlobal())
                .build();
    }

    private AlunoDTO toDTO(Aluno aluno) {
        return AlunoDTO.builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .cursosConcluidos(aluno.getCursosConcluidos())
                .mediaGlobal(aluno.getMediaGlobal())
                .build();
    }
}
