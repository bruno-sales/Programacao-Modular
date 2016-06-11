package com.unirio.controlador;

import com.unirio.acessorios.Baixador;
import com.unirio.modelo.LeitorLinhaPesquisa;
import com.unirio.modelo.LeitorProfessor;
import com.unirio.modelo.LeitorPrograma;
import com.unirio.modelo.LinhaPesquisa;
import com.unirio.modelo.Professor;
import com.unirio.modelo.Programa;
import java.util.List;

/**
 * Classe de controler. 
 */
public class Controlador {

    public static void main(String[] args) {

        System.out.println("Favor aguardar. Arquivos sendo baixados....");
        Baixador.baixarPrimeiroArquivo();
        Baixador.baixarSegundoArquivo();
        Baixador.baixarTerceiroArquivo();
        System.out.println("Download de arquivos terminado");
        
        
        List<Programa> programas = LeitorPrograma.recuperaDadosPrograma();
        for(Programa p : programas){
            
            List<LinhaPesquisa> linhasPesquisa = LeitorLinhaPesquisa.recuperaDadosLinhaPesquisa(p);
            for(LinhaPesquisa linhaPesquisa : linhasPesquisa){
                
                List<Professor> professores = LeitorProfessor.recuperaDadosProfessor();
                for(Professor professor : professores){
                    
                    String nomePrograma = p.getNome() ;
                    String nomePesquisa = linhaPesquisa.getNome();
                    String nomeProfessor= professor.getNome();
                    
                    System.out.println("Programa: " + nomePrograma + "  Linha de Pesquisa: " + nomePesquisa + " Professor: " + nomeProfessor + " .");
                
                }
                
            }

        }
        

        
    }  
  
}
