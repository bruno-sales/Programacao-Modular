package com.unirio.controlador;

import com.unirio.acessorios.Baixador;
import com.unirio.acessorios.GeraRelatorio;
import com.unirio.modelo.Curriculo;
import com.unirio.modelo.LeitorCurriculo;
import com.unirio.modelo.LeitorLinhaPesquisa;
import com.unirio.modelo.LeitorProfessor;
import com.unirio.modelo.LeitorPrograma;
import com.unirio.modelo.LinhaPesquisa;
import com.unirio.modelo.Professor;
import com.unirio.modelo.Programa;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Classe mantenedora da lógica de download de arquivos, carregamento de dados e
 * geração de relatório. - Controlador
 */
public class Controlador {
    
    public Controlador(){
    }

    /*
     * Método para realização do download de arquivos
     */
    public void baixaArquivos() {
        
        System.out.println("Favor aguardar. Arquivos sendo baixados....");
        
        Baixador.baixarQualis();
        
        Baixador.baixarProgramasXml();
        
        Baixador.baixarContentsXml();
        
        Baixador.baixarCurriculosXml();
        
        System.out.println("Download de arquivos terminado");
    
    }

    /*
     * Método percorre a hierarquia desde programa até currículo realizando e delegando preenchimento de objetos. 
     */
    public Programa carregaDados(String nomePrograma, int anoInicio, int anoFim) {
        
        System.out.println("Carregando os Dados");

        LeitorPrograma leitorPrograma = new LeitorPrograma();

        Programa p = leitorPrograma.recuperaDadosPrograma(nomePrograma);

        LeitorLinhaPesquisa leitorLinhaPesquisa = new LeitorLinhaPesquisa();

        List<LinhaPesquisa> linhasPesquisa = leitorLinhaPesquisa.recuperaDadosLinhaPesquisa(p);
        
        p.setLinhasPesquisa(linhasPesquisa);

        for (LinhaPesquisa linhaPesquisa : linhasPesquisa) {

            LeitorProfessor leitorProfessor = new LeitorProfessor();
            List<Professor> professores = leitorProfessor.recuperaDadosProfessor(linhaPesquisa.getNome());
            linhaPesquisa.setProfessores(professores);

            for (Professor professor : professores) {
                
                LeitorCurriculo leitorCurriculo = new LeitorCurriculo();
                String codProf = professor.getCodigo();
                Curriculo curriculo = leitorCurriculo.recuperaDadosCurriculo(codProf, anoInicio, anoFim);
                professor.setCurriculo(curriculo);

            }

        }

        return p;
    }

    /*
     * Método para gerar arquivo txt relatório.
     */
    public void geraRelatorio(Programa p) throws FileNotFoundException, UnsupportedEncodingException {
        
        GeraRelatorio instanciaGeradora = new GeraRelatorio();
        instanciaGeradora.criarRelatorio(p);
        
    }

}
