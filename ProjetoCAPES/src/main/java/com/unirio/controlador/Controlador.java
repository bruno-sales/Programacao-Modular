package com.unirio.controlador;

import com.unirio.acessorios.Baixador;
import com.unirio.modelo.LeitorLinhaPesquisa;
import com.unirio.modelo.LeitorProfessor;
import com.unirio.modelo.LeitorPrograma;
import com.unirio.modelo.LinhaPesquisa;
import com.unirio.modelo.Professor;
import com.unirio.modelo.Programa;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de controler. 
 */
public class Controlador {

    public static void main(String[] args) {

        Baixador.baixarPrimeiroArquivo();
        Baixador.baixarSegundoArquivo();
        Baixador.baixarTerceiroArquivo();
        List<Programa> programas = LeitorPrograma.recuperaDadosPrograma();
        for(Programa p : programas){
            
            List<LinhaPesquisa> linhasPesquisa = LeitorLinhaPesquisa.recuperaDadosLinhaPesquisa(p);
            for(LinhaPesquisa linhaPesquisa : linhasPesquisa){
                
                List<Professor> professores = LeitorProfessor.recuperaDadosProfessor();
                for(Professor professor : professores){
                
                    System.out.println("Programa: " + p.getNome() + "  Linha de Pesquisa: " + linhaPesquisa.getNome() + " Professor: " + professor.getNome() + " .");
                
                }
                
            }

        }
        

        
    }  
  
}
