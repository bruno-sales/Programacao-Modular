package com.unirio.modelo;
import lombok.Data;


public @Data class Curriculo {
    
    private int artigosRevistasA1;
    private int artigosRevistasA2;
    private int artigosRevistasB1;
    private int artigosRevistasB2;
    private int artigosRevistasB3;
    private int artigosRevistasB4;
    private int artigosRevistasC;
    private int artigosRevistasNC;
    private int artigosEventosA1;
    private int artigosEventosA2;
    private int artigosEventosB1;
    private int artigosEventosB2;
    private int artigosEventosB3;
    private int artigosEventosB4;
    private int artigosEventosC;
    private int artigosEventosNC;
    private int participacoesBancasDoutorado;
    private int participacoesBancasMestrado;
    private int participacoesBancasGraduacao;
    private int orientacoesDoutoradoConcluidas;
    private int orientacoesMestradoConcluidas;
    private int orientacoesGraduacaoConcluidas;
    private int orientacoesDoutoradoEmAndamento;
    private int orientacoesMestradoEmAndamento;
    private int orientacoesGraduacaoEmAndamento;

    public Curriculo(int artigosRevistasA1, int artigosRevistasA2, int artigosRevistasB1, int artigosRevistasB2, int artigosRevistasB3, int artigosRevistasB4, int artigosRevistasC, int artigosRevistasNC, int artigosEventosA1, int artigosEventosA2, int artigosEventosB1, int artigosEventosB2, int artigosEventosB3, int artigosEventosB4, int artigosEventosC, int artigosEventosNC, int participacoesBancasDoutorado, int participacoesBancasMestrado, int participacoesBancasGraduacao, int orientacoesDoutoradoConcluidas, int orientacoesMestradoConcluidas, int orientacoesGraduacaoConcluidas, int orientacoesDoutoradoEmAndamento, int orientacoesMestradoEmAndamento, int orientacoesGraduacaoEmAndamento) {
        this.artigosRevistasA1 = artigosRevistasA1;
        this.artigosRevistasA2 = artigosRevistasA2;
        this.artigosRevistasB1 = artigosRevistasB1;
        this.artigosRevistasB2 = artigosRevistasB2;
        this.artigosRevistasB3 = artigosRevistasB3;
        this.artigosRevistasB4 = artigosRevistasB4;
        this.artigosRevistasC = artigosRevistasC;
        this.artigosRevistasNC = artigosRevistasNC;
        this.artigosEventosA1 = artigosEventosA1;
        this.artigosEventosA2 = artigosEventosA2;
        this.artigosEventosB1 = artigosEventosB1;
        this.artigosEventosB2 = artigosEventosB2;
        this.artigosEventosB3 = artigosEventosB3;
        this.artigosEventosB4 = artigosEventosB4;
        this.artigosEventosC = artigosEventosC;
        this.artigosEventosNC = artigosEventosNC;
        this.participacoesBancasDoutorado = participacoesBancasDoutorado;
        this.participacoesBancasMestrado = participacoesBancasMestrado;
        this.participacoesBancasGraduacao = participacoesBancasGraduacao;
        this.orientacoesDoutoradoConcluidas = orientacoesDoutoradoConcluidas;
        this.orientacoesMestradoConcluidas = orientacoesMestradoConcluidas;
        this.orientacoesGraduacaoConcluidas = orientacoesGraduacaoConcluidas;
        this.orientacoesDoutoradoEmAndamento = orientacoesDoutoradoEmAndamento;
        this.orientacoesMestradoEmAndamento = orientacoesMestradoEmAndamento;
        this.orientacoesGraduacaoEmAndamento = orientacoesGraduacaoEmAndamento;
    }

    public Curriculo() {
    }

    public void qualificaArtigos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
}
