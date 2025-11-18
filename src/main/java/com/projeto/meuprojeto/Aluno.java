package com.projeto.meuprojeto;

public class Aluno {

    private static final int    MIN_CURSOS = 3;
    private static final double MEDIA_ALTA = 8.0;
    private static final double MEDIA_MEDIA = 7.0;
    private static final double DESCONTO_ALTA  = 0.40;
    private static final double DESCONTO_MEDIA = 0.20;
    private static final double SEM_DESCONTO   = 0.0;
    public  static final String MSG_CURSOS_INSUF =
            "Precisa completar pelo menos 3 cursos para ter direito ao desconto";

    private final String nome;
    private final int cursosConcluidos;
    private final double mediaGlobal;

    public Aluno(String nome, int cursosConcluidos, double mediaGlobal) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.mediaGlobal = mediaGlobal;
    }

    public int getCursosConcluidos() { return cursosConcluidos; }
    public double getMediaGlobal()    { return mediaGlobal; }

    public double solicitarDesconto() {
        if (!temCursosSuficientes()) return SEM_DESCONTO;
        return calcularDescontoPorMedia(mediaGlobal);
    }

    public String solicitarDescontoComMensagem() {
        if (!temCursosSuficientes()) return MSG_CURSOS_INSUF;
        int percentual = (int) Math.round(solicitarDesconto() * 100);
        return "Desconto aplicado: " + percentual + "%";
    }

    private boolean temCursosSuficientes() {
        return cursosConcluidos >= MIN_CURSOS;
    }

    private static double calcularDescontoPorMedia(double media) {
        if (media >= MEDIA_ALTA)  return DESCONTO_ALTA;
        if (media >= MEDIA_MEDIA) return DESCONTO_MEDIA;
        return SEM_DESCONTO;
    }
}
