/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.controlador;
import com.unirio.acessorios.Baixador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe de controller. Coloquei o metodo main aqui
 */
public class Controlador {

    public static void main(String[] args) {
        
        String url = "https://s3.amazonaws.com/posgraduacao/programas.xml";
        String nome = "programas.xml";                
                
        try {
            Baixador.BaixarArquivo(nome,url);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
