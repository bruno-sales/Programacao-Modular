/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.baseTests;

import com.unirio.modelo.Curriculo;
import com.unirio.modelo.LeitorCurriculo;
import com.unirio.modelo.LeitorLinhaPesquisa;
import com.unirio.modelo.LeitorProfessor;
import com.unirio.modelo.LeitorPrograma;
import com.unirio.modelo.Professor;
import com.unirio.modelo.Programa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
 
        Programa programaTeste = new Programa("PPGI-UNIRIO");
        assertEquals(3, (LeitorLinhaPesquisa.recuperaDadosLinhaPesquisa(programaTeste)).size());
 
    }

    @Test
    public void TestNomePrograma(){

        assertEquals("PPGI-UNIRIO", (LeitorPrograma.recuperaDadosPrograma("PPGI-UNIRIO")).getNome());

    }
    
    @Test
    public void TestQuantidadeProfessoresLinhaPesquisa(){
        
        assertEquals(7, (LeitorProfessor.recuperaDadosProfessor("Sistemas de Apoio a Negócios")).size());
    
    }
    
    @Test
    public void TestQuantidadeArtigosEmRevista(){
        
        Curriculo curriculoKate = LeitorCurriculo.recuperaDadosCurriculo("0814717344017544", 2000, 2016);
        assertEquals(6, (curriculoKate.getArtigosRevistasA1() + curriculoKate.getArtigosRevistasA2() + curriculoKate.getArtigosRevistasB1() + curriculoKate.getArtigosRevistasB2() + + curriculoKate.getArtigosRevistasB3() + curriculoKate.getArtigosRevistasB4() + curriculoKate.getArtigosRevistasB5() + + curriculoKate.getArtigosRevistasC() + + curriculoKate.getArtigosRevistasNC()));
    
    }
    
    @Test
    public void TestQuantidadeOrientacaoMestradoConcluidas(){
        
        Curriculo curriculoKate = LeitorCurriculo.recuperaDadosCurriculo("0814717344017544", 2000, 2016);
        assertEquals(13, curriculoKate.getOrientacoesMestradoConcluidas());
    
    }
 }