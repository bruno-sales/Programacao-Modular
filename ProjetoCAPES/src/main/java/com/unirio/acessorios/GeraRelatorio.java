/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.acessorios;

import com.unirio.modelo.Curriculo;
import com.unirio.modelo.LinhaPesquisa;
import com.unirio.modelo.Professor;
import com.unirio.modelo.Programa;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * Classe responsável por montar a estrutura geradora de relatórios
 */
public class GeraRelatorio {

    public GeraRelatorio() {
    }

    public void criarRelatorio(Programa p) throws FileNotFoundException, UnsupportedEncodingException {

        String nomeArquivo = p.getNome() + ".txt";
        PrintWriter writer = new PrintWriter(nomeArquivo, "UTF-8");

        //Cabecalho
        writer.println("Nome do Professor\t"
                + "RevA1\tRevA2\tRevB1\tRevB2\tRevB3\tRevB4\tRevB5\tRevC\tRevN/C\t"
                + "EveA1\tEveA2\tEveB1\tEveB2\tEveB3\tEveB4\tEveB5\tEveC\tEveN/C\t"
                + "bancasD\tbancasM\tbancasG\tOriCoD\tOriCoM\tOriCoG\tOriAnD\tOriAnM\tOriAnG");

        float pRevistasA1 = 0;
        float pRevistasA2 = 0;
        float pRevistasB1 = 0;
        float pRevistasB2 = 0;
        float pRevistasB3 = 0;
        float pRevistasB4 = 0;
        float pRevistasB5 = 0;
        float pRevistasC = 0;
        float pRevistasNC = 0;
        float pEventosA1 = 0;
        float pEventosA2 = 0;
        float pEventosB1 = 0;
        float pEventosB2 = 0;
        float pEventosB3 = 0;
        float pEventosB4 = 0;
        float pEventosB5 = 0;
        float pEventosC = 0;
        float pEventosNC = 0;
        float pParticipacaoDoutorado = 0;
        float pParticipacaoMestrado = 0;
        float pParticipacaoGraducao = 0;
        float pOrientacaoConcluidaDoutorado = 0;
        float pOrientacaoConcluidaMestrado = 0;
        float pOrientacaoConcluidaGraducao = 0;
        float pOrientacaoAndamentoDoutorado = 0;
        float pOrientacaoAndamentoMestrado = 0;
        float pOrientacaoAndamentoGraducao = 0;

        for (LinhaPesquisa lp : p.getLinhasPesquisa()) {

            float lpRevistasA1 = 0;
            float lpRevistasA2 = 0;
            float lpRevistasB1 = 0;
            float lpRevistasB2 = 0;
            float lpRevistasB3 = 0;
            float lpRevistasB4 = 0;
            float lpRevistasB5 = 0;
            float lpRevistasC = 0;
            float lpRevistasNC = 0;
            float lpEventosA1 = 0;
            float lpEventosA2 = 0;
            float lpEventosB1 = 0;
            float lpEventosB2 = 0;
            float lpEventosB3 = 0;
            float lpEventosB4 = 0;
            float lpEventosB5 = 0;
            float lpEventosC = 0;
            float lpEventosNC = 0;
            float lpParticipacaoDoutorado = 0;
            float lpParticipacaoMestrado = 0;
            float lpParticipacaoGraducao = 0;
            float lpOrientacaoConcluidaDoutorado = 0;
            float lpOrientacaoConcluidaMestrado = 0;
            float lpOrientacaoConcluidaGraducao = 0;
            float lpOrientacaoAndamentoDoutorado = 0;
            float lpOrientacaoAndamentoMestrado = 0;
            float lpOrientacaoAndamentoGraducao = 0;

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
            int numeroProfessores = lp.getProfessores().size();
            
            dadosLinhaPesquisa.append("Total da Linha de pesquisa ").append(lp.getNome());
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasA1 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasA2 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasB1 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasB2 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasB3 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasB4 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasB5 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasC / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpRevistasNC / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosA1 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosA2 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosB1 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosB2 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosB3 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosB4 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosB5 / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosC / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpEventosNC / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpParticipacaoDoutorado / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpParticipacaoMestrado / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpParticipacaoGraducao / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpOrientacaoConcluidaDoutorado / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpOrientacaoConcluidaMestrado / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpOrientacaoConcluidaGraducao / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpOrientacaoAndamentoDoutorado / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpOrientacaoAndamentoMestrado / numeroProfessores));
            dadosLinhaPesquisa.append("\t").append(String.format("%.1f", lpOrientacaoAndamentoGraducao / numeroProfessores));
            writer.println(dadosLinhaPesquisa); /////Escrever no txt

            pRevistasA1 += lpRevistasA1 / numeroProfessores;
            pRevistasA2 += lpRevistasA2 / numeroProfessores;
            pRevistasB1 += lpRevistasB1 / numeroProfessores;
            pRevistasB2 += lpRevistasB2 / numeroProfessores;
            pRevistasB3 += lpRevistasB3 / numeroProfessores;
            pRevistasB4 += lpRevistasB4 / numeroProfessores;
            pRevistasB5 += lpRevistasB5 / numeroProfessores;
            pRevistasC += lpRevistasC / numeroProfessores;
            pRevistasNC += lpRevistasNC / numeroProfessores;
            pEventosA1 += lpEventosA1 / numeroProfessores;
            pEventosA2 += lpEventosA2 / numeroProfessores;
            pEventosB1 += lpEventosB1 / numeroProfessores;
            pEventosB2 += lpEventosB2 / numeroProfessores;
            pEventosB3 += lpEventosB3 / numeroProfessores;
            pEventosB4 += lpEventosB4 / numeroProfessores;
            pEventosB5 += lpEventosB5 / numeroProfessores;
            pEventosC += lpEventosC / numeroProfessores;
            pEventosNC += lpEventosNC / numeroProfessores;
            pParticipacaoDoutorado += lpParticipacaoDoutorado / numeroProfessores;
            pParticipacaoMestrado += lpParticipacaoMestrado / numeroProfessores;
            pParticipacaoGraducao += lpParticipacaoGraducao / numeroProfessores;
            pOrientacaoConcluidaDoutorado += lpOrientacaoConcluidaDoutorado / numeroProfessores;
            pOrientacaoConcluidaMestrado += lpOrientacaoConcluidaMestrado / numeroProfessores;
            pOrientacaoConcluidaGraducao += lpOrientacaoConcluidaGraducao / numeroProfessores;
            pOrientacaoAndamentoDoutorado += lpOrientacaoAndamentoDoutorado / numeroProfessores;
            pOrientacaoAndamentoMestrado += lpOrientacaoAndamentoMestrado / numeroProfessores;
            pOrientacaoAndamentoGraducao += lpOrientacaoAndamentoGraducao / numeroProfessores;
        }
        StringBuilder dadosPrograma = new StringBuilder();
        int numeroLinhasPesquisas = p.getLinhasPesquisa().size();
        
        dadosPrograma.append("Total do Programa ").append(p.getNome());
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasA1 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasA2 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasB1 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasB2 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasB3 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasB4 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasB5 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasC / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pRevistasNC / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosA1 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosA2 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosB1 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosB2 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosB3 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosB4 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosB5 / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosC / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pEventosNC / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pParticipacaoDoutorado / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pParticipacaoMestrado / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pParticipacaoGraducao / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pOrientacaoConcluidaDoutorado / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pOrientacaoConcluidaMestrado / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pOrientacaoConcluidaGraducao / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pOrientacaoAndamentoDoutorado / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pOrientacaoAndamentoMestrado / numeroLinhasPesquisas));
        dadosPrograma.append("\t").append(String.format("%.1f", pOrientacaoAndamentoGraducao / numeroLinhasPesquisas));
        writer.println(dadosPrograma); /////Escrever no txt

        writer.close(); //////Finalizar txt

    }

}
