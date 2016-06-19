/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.controlador;

import com.unirio.modelo.Programa;
import java.util.List;

/**
 *
 * @author labccet
 */
public class Main {

    public static void main(String[] args) {
        Controlador.baixaArquivos();
        List<Programa> programas = Controlador.carregaDados();
        Controlador.geraRelatorio(programas);
    }
}
