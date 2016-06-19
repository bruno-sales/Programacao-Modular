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

    public static void baixaArquivos() {
        System.out.println("Favor aguardar. Arquivos sendo baixados....");
        Baixador.baixarQualis();
        Baixador.baixarPrimeiroArquivo();
        Baixador.baixarSegundoArquivo();
        Baixador.baixarTerceiroArquivo();
        System.out.println("Download de arquivos terminado");
    }

    public static List<Programa> carregaDados() {
        List<Programa> programas = LeitorPrograma.recuperaDadosPrograma();
        for (Programa p : programas) {

            List<LinhaPesquisa> linhasPesquisa = LeitorLinhaPesquisa.recuperaDadosLinhaPesquisa(p);
            p.setLinhasPesquisa(linhasPesquisa);

            for (LinhaPesquisa linhaPesquisa : linhasPesquisa) {

                List<Professor> professores = LeitorProfessor.recuperaDadosProfessor(linhaPesquisa.getNome());
                linhaPesquisa.setProfessores(professores);

                for (Professor professor : professores) {

                    String codProf = professor.getCodigo();

                    Curriculo curriculo = LeitorCurriculo.recuperaDadosCurriculo(codProf);
                    professor.setCurriculo(curriculo);

                }

            }

        }
        return programas;
    }

    static void geraRelatorio(List<Programa> programas) {
        for (Programa p : programas) {
            for (LinhaPesquisa lp : p.getLinhasPesquisa()) {
                for (Professor prof : lp.getProfessores()) {
                    prof.getCurriculo().escrever();
                }
            }
        }
    }

}
