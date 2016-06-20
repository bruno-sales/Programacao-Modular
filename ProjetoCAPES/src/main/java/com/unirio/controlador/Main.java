/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.controlador;

import com.unirio.modelo.Programa;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author labccet
 */
public class Main {

    public static void main(String[] args) {
        //Preenche valores de execução default
        String nomePrograma = "PPGI-UNIRIO";
        int anoInicio = 2003;
        int anoFim = 2016;
       
        //Checa se parâmetros foram passados na execução e preenche respectivas variáveis de execução
        if (args.length == 3) {
            try {

                nomePrograma = args[0];
                anoInicio = Integer.parseInt(args[1]);
                anoFim = Integer.parseInt(args[2]);

            } catch (NumberFormatException e) {

                System.err.println("Problema nos argumentos passados");
                System.exit(1);
            }
        }
        
        Controlador.baixaArquivos();
        
        Programa programa = Controlador.carregaDados(nomePrograma, anoInicio, anoFim);
        
        try {
            Controlador.geraRelatorio(programa);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
