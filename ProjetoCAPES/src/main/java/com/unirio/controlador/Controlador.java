package com.unirio.controlador;

import com.unirio.acessorios.Baixador;

/**
 * Classe de controler. 
 */
public class Controlador {

    public static void main(String[] args) {

        Baixador.baixarPrimeiroArquivo();
        Baixador.baixarSegundoArquivo();
        Baixador.baixarTerceiroArquivo();
    }  
  
}
