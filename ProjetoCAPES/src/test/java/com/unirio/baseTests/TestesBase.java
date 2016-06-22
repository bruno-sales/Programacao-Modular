/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.baseTests;

import com.unirio.controlador.Controlador;
import com.unirio.modelo.Curriculo;
import com.unirio.modelo.LeitorCurriculo;
import com.unirio.modelo.LeitorLinhaPesquisa;
import com.unirio.modelo.LeitorProfessor;
import com.unirio.modelo.LeitorPrograma;
import com.unirio.modelo.Programa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bruno
 */
public class TestesBase {

    public TestesBase() {
    }
    
    @Test
    public void TestQuantidadeLinhasPesquisa() {
        
        Controlador instanciaController = new Controlador();
        
        instanciaController.baixaArquivos();
        
        Programa programaTeste = new Programa("PPGI-UNIRIO");
        LeitorLinhaPesquisa leitorLinhaPesquisa = new LeitorLinhaPesquisa();
        
        assertEquals(3, (leitorLinhaPesquisa.recuperaDadosLinhaPesquisa(programaTeste)).size());
 
    }

    @Test
    public void TestNomePrograma(){
        
        LeitorPrograma leitorPrograma = new LeitorPrograma();
        
        assertEquals("PPGI-UNIRIO", (leitorPrograma.recuperaDadosPrograma("PPGI-UNIRIO")).getNome());

    }
    
    @Test
    public void TestQuantidadeProfessoresLinhaPesquisa(){
        LeitorProfessor leitorProfessor = new LeitorProfessor();
        
        assertEquals(7, (leitorProfessor.recuperaDadosProfessor("Sistemas de Apoio a Negócios")).size());
    
    }
    
    @Test
    public void TestQuantidadeArtigosEmRevista(){
        
        LeitorCurriculo leitorCurriculo = new LeitorCurriculo();
        
        Curriculo curriculoKate = leitorCurriculo.recuperaDadosCurriculo("0814717344017544", 2000, 2016);
        assertEquals(6, (curriculoKate.getArtigosRevistasA1() + curriculoKate.getArtigosRevistasA2() + curriculoKate.getArtigosRevistasB1() + curriculoKate.getArtigosRevistasB2() + + curriculoKate.getArtigosRevistasB3() + curriculoKate.getArtigosRevistasB4() + curriculoKate.getArtigosRevistasB5() + + curriculoKate.getArtigosRevistasC() + + curriculoKate.getArtigosRevistasNC()));
    
    }
    
    @Test
    public void TestQuantidadeOrientacaoMestradoConcluidas(){
        LeitorCurriculo leitorCurriculo = new LeitorCurriculo();
        
        Curriculo curriculoKate = leitorCurriculo.recuperaDadosCurriculo("0814717344017544", 2000, 2016);
        assertEquals(13, curriculoKate.getOrientacoesMestradoConcluidas());
    
    }
   
    
 }