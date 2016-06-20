/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.baseTests;

import com.unirio.modelo.LeitorLinhaPesquisa;
import com.unirio.modelo.LeitorProfessor;
import com.unirio.modelo.LeitorPrograma;
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

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestPrograma() {
        Programa programaTeste = new Programa("PPGI-UNIRIO");
        assertEquals(3, (LeitorLinhaPesquisa.recuperaDadosLinhaPesquisa(programaTeste)).size());
        assertEquals("PPGI-UNIRIO", (LeitorPrograma.recuperaDadosPrograma("PPGI-UNIRIO")).getNome());
        assertEquals(7, (LeitorProfessor.recuperaDadosProfessor("Sistemas de Apoio a Negócios")).size());
    }
}
