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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Classe mantenedora da lógica de download de arquivos, carregamento de dados e
 * geração de relatório. - Controlador
 */
public class Controlador {

    /*
     Método para realização do download de arquivos
     */
    public static void baixaArquivos() {
        System.out.println("Favor aguardar. Arquivos sendo baixados....");
        Baixador.baixarQualis();
        Baixador.baixarPrimeiroArquivo();
        Baixador.baixarSegundoArquivo();
        Baixador.baixarTerceiroArquivo();
        System.out.println("Download de arquivos terminado");
    }

    /*
     Método percorre a hierarquia desde programa até currículo realizando e delegando preenchimento de objetos. 
     */
    public static Programa carregaDados(String nomePrograma, int anoInicio, int anoFim) {
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
     Método para gerar arquivo txt relatório.
     */
    static void geraRelatorio(Programa p) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("relatorio.txt", "UTF-8");

        //Cabecalho
        writer.println("Nome do Professor\t"
                + "RevA1\ttRevA2\ttRevB1\ttRevB2\ttRevB3\ttRevB4\ttRevB5\ttRevC\tRevN/C\t"
                + "EveA1\ttEveA2\ttEveB1\ttEveB2\ttEveB3\ttEveB4\ttEveB5\ttEveC\ttEveN/C\t"
                + "bancasD\ttbancasM\tbancasG\tOriCoD\tOriCoM\tOriCoG\tOriAnD\tOriAnM\tOriAnG");

        int pRevistasA1 = 0;
        int pRevistasA2 = 0;
        int pRevistasB1 = 0;
        int pRevistasB2 = 0;
        int pRevistasB3 = 0;
        int pRevistasB4 = 0;
        int pRevistasB5 = 0;
        int pRevistasC = 0;
        int pRevistasNC = 0;
        int pEventosA1 = 0;
        int pEventosA2 = 0;
        int pEventosB1 = 0;
        int pEventosB2 = 0;
        int pEventosB3 = 0;
        int pEventosB4 = 0;
        int pEventosB5 = 0;
        int pEventosC = 0;
        int pEventosNC = 0;
        int pParticipacaoDoutorado = 0;
        int pParticipacaoMestrado = 0;
        int pParticipacaoGraducao = 0;
        int pOrientacaoConcluidaDoutorado = 0;
        int pOrientacaoConcluidaMestrado = 0;
        int pOrientacaoConcluidaGraducao = 0;
        int pOrientacaoAndamentoDoutorado = 0;
        int pOrientacaoAndamentoMestrado = 0;
        int pOrientacaoAndamentoGraducao = 0;

        for (LinhaPesquisa lp : p.getLinhasPesquisa()) {

            int lpRevistasA1 = 0;
            int lpRevistasA2 = 0;
            int lpRevistasB1 = 0;
            int lpRevistasB2 = 0;
            int lpRevistasB3 = 0;
            int lpRevistasB4 = 0;
            int lpRevistasB5 = 0;
            int lpRevistasC = 0;
            int lpRevistasNC = 0;
            int lpEventosA1 = 0;
            int lpEventosA2 = 0;
            int lpEventosB1 = 0;
            int lpEventosB2 = 0;
            int lpEventosB3 = 0;
            int lpEventosB4 = 0;
            int lpEventosB5 = 0;
            int lpEventosC = 0;
            int lpEventosNC = 0;
            int lpParticipacaoDoutorado = 0;
            int lpParticipacaoMestrado = 0;
            int lpParticipacaoGraducao = 0;
            int lpOrientacaoConcluidaDoutorado = 0;
            int lpOrientacaoConcluidaMestrado = 0;
            int lpOrientacaoConcluidaGraducao = 0;
            int lpOrientacaoAndamentoDoutorado = 0;
            int lpOrientacaoAndamentoMestrado = 0;
            int lpOrientacaoAndamentoGraducao = 0;

            for (Professor prof : lp.getProfessores()) {
                Curriculo curriculoProf = prof.getCurriculo();

                StringBuilder dadosProf = new StringBuilder();
                dadosProf.append("Professor ").append(prof.getNome());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasA1());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasA2());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasB1());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasB2());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasB3());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasB4());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasB5());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasC());
                dadosProf.append("\t").append(curriculoProf.getArtigosRevistasNC());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosA1());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosA2());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosB1());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosB2());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosB3());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosB4());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosB5());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosC());
                dadosProf.append("\t").append(curriculoProf.getArtigosEventosNC());
                dadosProf.append("\t").append(curriculoProf.getParticipacoesBancasDoutorado());
                dadosProf.append("\t").append(curriculoProf.getParticipacoesBancasMestrado());
                dadosProf.append("\t").append(curriculoProf.getParticipacoesBancasGraduacao());
                dadosProf.append("\t").append(curriculoProf.getOrientacoesDoutoradoConcluidas());
                dadosProf.append("\t").append(curriculoProf.getOrientacoesMestradoConcluidas());
                dadosProf.append("\t").append(curriculoProf.getOrientacoesGraduacaoConcluidas());
                dadosProf.append("\t").append(curriculoProf.getOrientacoesDoutoradoEmAndamento());
                dadosProf.append("\t").append(curriculoProf.getOrientacoesMestradoEmAndamento());
                dadosProf.append("\t").append(curriculoProf.getOrientacoesGraduacaoEmAndamento());
                writer.println(dadosProf.toString()); /////////Escreve no txt

                lpRevistasA1 += curriculoProf.getArtigosRevistasA1();
                lpRevistasA2 += curriculoProf.getArtigosRevistasA2();
                lpRevistasB1 += curriculoProf.getArtigosRevistasB1();
                lpRevistasB2 += curriculoProf.getArtigosRevistasB2();
                lpRevistasB3 += curriculoProf.getArtigosRevistasB3();
                lpRevistasB4 += curriculoProf.getArtigosRevistasB4();
                lpRevistasB5 += curriculoProf.getArtigosRevistasB5();
                lpRevistasC += curriculoProf.getArtigosRevistasC();
                lpRevistasNC += curriculoProf.getArtigosRevistasNC();
                lpEventosA1 += curriculoProf.getArtigosEventosA1();
                lpEventosA2 += curriculoProf.getArtigosEventosA2();
                lpEventosB1 += curriculoProf.getArtigosEventosB1();
                lpEventosB2 += curriculoProf.getArtigosEventosB2();
                lpEventosB3 += curriculoProf.getArtigosEventosB3();
                lpEventosB4 += curriculoProf.getArtigosEventosB4();
                lpEventosB5 += curriculoProf.getArtigosEventosB5();
                lpEventosC += curriculoProf.getArtigosEventosC();
                lpEventosNC += curriculoProf.getArtigosEventosNC();
                lpParticipacaoDoutorado += curriculoProf.getParticipacoesBancasDoutorado();
                lpParticipacaoMestrado += curriculoProf.getParticipacoesBancasMestrado();
                lpParticipacaoGraducao += curriculoProf.getParticipacoesBancasGraduacao();
                lpOrientacaoConcluidaDoutorado += curriculoProf.getOrientacoesDoutoradoConcluidas();
                lpOrientacaoConcluidaMestrado += curriculoProf.getOrientacoesMestradoConcluidas();
                lpOrientacaoConcluidaGraducao += curriculoProf.getOrientacoesGraduacaoConcluidas();
                lpOrientacaoAndamentoDoutorado += curriculoProf.getOrientacoesDoutoradoEmAndamento();
                lpOrientacaoAndamentoMestrado += curriculoProf.getOrientacoesMestradoEmAndamento();
                lpOrientacaoAndamentoGraducao += curriculoProf.getOrientacoesGraduacaoEmAndamento();
            }
            StringBuilder dadosLinhaPesquisa = new StringBuilder();
            dadosLinhaPesquisa.append("Total da Linha de pesquisa ").append(lp.getNome());
            dadosLinhaPesquisa.append("\t").append(lpRevistasA1);
            dadosLinhaPesquisa.append("\t").append(lpRevistasA2);
            dadosLinhaPesquisa.append("\t").append(lpRevistasB1);
            dadosLinhaPesquisa.append("\t").append(lpRevistasB2);
            dadosLinhaPesquisa.append("\t").append(lpRevistasB3);
            dadosLinhaPesquisa.append("\t").append(lpRevistasB4);
            dadosLinhaPesquisa.append("\t").append(lpRevistasB5);
            dadosLinhaPesquisa.append("\t").append(lpRevistasC);
            dadosLinhaPesquisa.append("\t").append(lpRevistasNC);
            dadosLinhaPesquisa.append("\t").append(lpEventosA1);
            dadosLinhaPesquisa.append("\t").append(lpEventosA2);
            dadosLinhaPesquisa.append("\t").append(lpEventosB1);
            dadosLinhaPesquisa.append("\t").append(lpEventosB2);
            dadosLinhaPesquisa.append("\t").append(lpEventosB3);
            dadosLinhaPesquisa.append("\t").append(lpEventosB4);
            dadosLinhaPesquisa.append("\t").append(lpEventosB5);
            dadosLinhaPesquisa.append("\t").append(lpEventosC);
            dadosLinhaPesquisa.append("\t").append(lpEventosNC);
            dadosLinhaPesquisa.append("\t").append(lpParticipacaoDoutorado);
            dadosLinhaPesquisa.append("\t").append(lpParticipacaoMestrado);
            dadosLinhaPesquisa.append("\t").append(lpParticipacaoGraducao);
            dadosLinhaPesquisa.append("\t").append(lpOrientacaoConcluidaDoutorado);
            dadosLinhaPesquisa.append("\t").append(lpOrientacaoConcluidaMestrado);
            dadosLinhaPesquisa.append("\t").append(lpOrientacaoConcluidaGraducao);
            dadosLinhaPesquisa.append("\t").append(lpOrientacaoAndamentoDoutorado);
            dadosLinhaPesquisa.append("\t").append(lpOrientacaoAndamentoMestrado);
            dadosLinhaPesquisa.append("\t").append(lpOrientacaoAndamentoGraducao);
            writer.println(dadosLinhaPesquisa); /////Escrever no txt

            pRevistasA1 += lpRevistasA1;
            pRevistasA2 += lpRevistasA2;
            pRevistasB1 += lpRevistasB1;
            pRevistasB2 += lpRevistasB2;
            pRevistasB3 += lpRevistasB3;
            pRevistasB4 += lpRevistasB4;
            pRevistasB5 += lpRevistasB5;
            pRevistasC += lpRevistasC;
            pRevistasNC += lpRevistasNC;
            pEventosA1 += lpEventosA1;
            pEventosA2 += lpEventosA2;
            pEventosB1 += lpEventosB1;
            pEventosB2 += lpEventosB2;
            pEventosB3 += lpEventosB3;
            pEventosB4 += lpEventosB4;
            pEventosB5 += lpEventosB5;
            pEventosC += lpEventosC;
            pEventosNC += lpEventosNC;
            pParticipacaoDoutorado += lpParticipacaoDoutorado;
            pParticipacaoMestrado += lpParticipacaoMestrado;
            pParticipacaoGraducao += lpParticipacaoGraducao;
            pOrientacaoConcluidaDoutorado += lpOrientacaoConcluidaDoutorado;
            pOrientacaoConcluidaMestrado += lpOrientacaoConcluidaMestrado;
            pOrientacaoConcluidaGraducao += lpOrientacaoConcluidaGraducao;
            pOrientacaoAndamentoDoutorado += lpOrientacaoAndamentoDoutorado;
            pOrientacaoAndamentoMestrado += lpOrientacaoAndamentoMestrado;
            pOrientacaoAndamentoGraducao += lpOrientacaoAndamentoGraducao;
        }
        StringBuilder dadosPrograma = new StringBuilder();
        dadosPrograma.append("Total do Programa ").append(p.getNome());
        dadosPrograma.append("\t").append(pRevistasA1);
        dadosPrograma.append("\t").append(pRevistasA2);
        dadosPrograma.append("\t").append(pRevistasB1);
        dadosPrograma.append("\t").append(pRevistasB2);
        dadosPrograma.append("\t").append(pRevistasB3);
        dadosPrograma.append("\t").append(pRevistasB4);
        dadosPrograma.append("\t").append(pRevistasB5);
        dadosPrograma.append("\t").append(pRevistasC);
        dadosPrograma.append("\t").append(pRevistasNC);
        dadosPrograma.append("\t").append(pEventosA1);
        dadosPrograma.append("\t").append(pEventosA2);
        dadosPrograma.append("\t").append(pEventosB1);
        dadosPrograma.append("\t").append(pEventosB2);
        dadosPrograma.append("\t").append(pEventosB3);
        dadosPrograma.append("\t").append(pEventosB4);
        dadosPrograma.append("\t").append(pEventosB5);
        dadosPrograma.append("\t").append(pEventosC);
        dadosPrograma.append("\t").append(pEventosNC);
        dadosPrograma.append("\t").append(pParticipacaoDoutorado);
        dadosPrograma.append("\t").append(pParticipacaoMestrado);
        dadosPrograma.append("\t").append(pParticipacaoGraducao);
        dadosPrograma.append("\t").append(pOrientacaoConcluidaDoutorado);
        dadosPrograma.append("\t").append(pOrientacaoConcluidaMestrado);
        dadosPrograma.append("\t").append(pOrientacaoConcluidaGraducao);
        dadosPrograma.append("\t").append(pOrientacaoAndamentoDoutorado);
        dadosPrograma.append("\t").append(pOrientacaoAndamentoMestrado);
        dadosPrograma.append("\t").append(pOrientacaoAndamentoGraducao);
        writer.println(dadosPrograma); /////Escrever no txt

        writer.close(); //////Finalizar txt
    }

}
