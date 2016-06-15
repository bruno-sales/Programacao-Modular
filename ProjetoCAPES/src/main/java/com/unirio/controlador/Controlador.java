package com.unirio.controlador;

import com.unirio.acessorios.Baixador;
import com.unirio.modelo.Curriculo;
import com.unirio.modelo.LeitorCurriculo;
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

    public static void baixaArquivos()
    {        
        System.out.println("Favor aguardar. Arquivos sendo baixados....");
        Baixador.baixarPrimeiroArquivo();
        Baixador.baixarSegundoArquivo();
        Baixador.baixarTerceiroArquivo();
        Baixador.baixarQualis();
        System.out.println("Download de arquivos terminado");
    }
    
    public static void carregaDados()
    {                
        List<Programa> programas = LeitorPrograma.recuperaDadosPrograma();
        for(Programa p : programas){
            
            List<LinhaPesquisa> linhasPesquisa = LeitorLinhaPesquisa.recuperaDadosLinhaPesquisa(p);
            for(LinhaPesquisa linhaPesquisa : linhasPesquisa){
                
                List<Professor> professores = LeitorProfessor.recuperaDadosProfessor();
                for(Professor professor : professores){
                    
                    Curriculo curriculo = LeitorCurriculo.recuperaDadosCurriculo();
                    curriculo.qualificaArtigos();
                    professor.setCurriculo(curriculo);
                    
                   /* String nomePrograma = p.getNome() ;
                    String nomePesquisa = linhaPesquisa.getNome();
                    String nomeProfessor= professor.getNome();
                    
                    System.out.println("Programa: " + nomePrograma + "  Linha de Pesquisa: " + nomePesquisa + " Professor: " + nomeProfessor + " .");*/
                
                }
                
            }

        }
    }

    static void geraRelatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
