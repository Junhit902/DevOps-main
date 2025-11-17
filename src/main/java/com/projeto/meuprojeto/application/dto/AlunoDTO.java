package com.projeto.meuprojeto.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoDTO {
    private Long id;
    private String nome;
    private Integer cursosConcluidos;
    private Double mediaGlobal;
}
