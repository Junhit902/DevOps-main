package com.projeto.meuprojeto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DescontoTest {

    // ==== BDDs principais ====

    @Test
    void bdd1_AlunoCom3CursosEMediaMaiorOuIgual8_DeveConceder40PorCento() {
        Aluno aluno = DadosAlunos.CESAR; // média 8.5, 3 cursos
        double desconto = aluno.solicitarDesconto();
        assertEquals(0.40, desconto, 1e-6);
    }

    @Test
    void bdd2_AlunoCom3CursosEMediaEntre7e79_DeveConceder20PorCento() {
        Aluno aluno = DadosAlunos.GUSTAVO; // média 7.5, 3 cursos
        double desconto = aluno.solicitarDesconto();
        assertEquals(0.20, desconto, 1e-6);
    }

    @Test
    void bdd3_AlunoCom3CursosEMediaMenorQue7_NaoDeveConcederDesconto() {
        Aluno aluno = DadosAlunos.THIAGO; // média 6.5, 3 cursos
        double desconto = aluno.solicitarDesconto();
        assertEquals(0.0, desconto, 1e-6);
    }

    @Test
    void bdd4_AlunoComMenosDe3Cursos_DeveExibirMensagem() {
        Aluno aluno = DadosAlunos.VINICIUS; // 2 cursos
        String mensagem = aluno.solicitarDescontoComMensagem();
        assertEquals(
            "Precisa completar pelo menos 3 cursos para ter direito ao desconto",
            mensagem
        );
    }

    @Test
    void media80_da40() {
        Aluno a = new Aluno("A", 3, 8.0);
        assertEquals(0.40, a.solicitarDesconto(), 1e-6);
    }

    @Test
    void media79_da20() {
        Aluno a = new Aluno("B", 3, 7.9);
        assertEquals(0.20, a.solicitarDesconto(), 1e-6);
    }

    @Test
    void media70_da20() {
        Aluno a = new Aluno("C", 3, 7.0);
        assertEquals(0.20, a.solicitarDesconto(), 1e-6);
    }

    @Test
    void cursosSuficientes_mediaBaixa_daZero() {
        Aluno a = new Aluno("D", 3, 6.99);
        assertEquals(0.0, a.solicitarDesconto(), 1e-6);
    }

    @Test
    void mensagem_quandoCursosSuficientes_mediaAlta_40() {
        Aluno a = new Aluno("E", 3, 8.1);
        assertEquals("Desconto aplicado: 40%", a.solicitarDescontoComMensagem());
    }

    @Test
    void mensagem_quandoCursosSuficientes_mediaMedia_20() {
        Aluno a = new Aluno("F", 3, 7.5);
        assertEquals("Desconto aplicado: 20%", a.solicitarDescontoComMensagem());
    }

}
