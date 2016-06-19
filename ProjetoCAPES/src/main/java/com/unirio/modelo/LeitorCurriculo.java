/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.modelo;

import com.unirio.acessorios.LeitorXml;
import com.unirio.acessorios.RecuperaXml;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Caroline
 */
public class LeitorCurriculo {

    private static final String ORIENTACOESCONCLUIDASPARAMESTRADO = "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO";
    private static final String ORIENTACOESCONCLUIDASPARADOUTORADO = "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO";
    private static final String ORIENTACOESCONCLUIDASPARAGRADUACAO = "OUTRAS-ORIENTACOES-CONCLUIDAS";

    private static final String ORIENTACAOEMANDAMENTODEMESTRADO = "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO";
    private static final String ORIENTACAOEMANDAMENTODEDOUTORADO = "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO";
    private static final String OUTRASORIENTACOESEMANDAMENTO = "OUTRAS-ORIENTACOES-EM-ANDAMENTO";

    private static final String PARTICIPACAOEMBANCADEMESTRADO = "PARTICIPACAO-EM-BANCA-DE-MESTRADO";
    private static final String PARTICIPACAOEMBANCADEDOUTORADO = "PARTICIPACAO-EM-BANCA-DE-DOUTORADO";
    private static final String PARTICIPACAOEMBANCADEGRADUACAO = "PARTICIPACAO-EM-BANCA-DE-GRADUACAO";

    private static final String TITULODOPERIODICOOUREVISTA = "TITULO-DO-PERIODICO-OU-REVISTA";
    private static final String DETALHAMENTODOARTIGO = "DETALHAMENTO-DO-ARTIGO";
    private static final String DETALHAMENTODOTRABALHO = "DETALHAMENTO-DO-TRABALHO";
    private static final String TITULODOSANAISOUPROCEEDINGS  = "TITULO-DOS-ANAIS-OU-PROCEEDINGS";

       


    public static Curriculo recuperaDadosCurriculo(String codProfessor) {

        Curriculo curriculo = new Curriculo();

        List<Element> orientacoesMestradoConcluidasItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", ORIENTACOESCONCLUIDASPARAMESTRADO);
        List<Element> orientacoesDoutoradoConcluidasItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", ORIENTACOESCONCLUIDASPARADOUTORADO);
        List<Element> orientacoesGraduacaoConcluidasItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", ORIENTACOESCONCLUIDASPARAGRADUACAO);

        List<Element> participacaoMestradoItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", PARTICIPACAOEMBANCADEMESTRADO);
        List<Element> participacaoDoutoradoItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", PARTICIPACAOEMBANCADEDOUTORADO);
        List<Element> participacaoGraduacaoItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", PARTICIPACAOEMBANCADEGRADUACAO);

        List<Element> orientacoesMestradoEmAndamentoItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", ORIENTACAOEMANDAMENTODEMESTRADO);
        List<Element> orientacoesDoutoradoEmAndamentoItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", ORIENTACAOEMANDAMENTODEDOUTORADO);
        List<Element> orientacoesGraduacaoEmAndamentoItens = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", OUTRASORIENTACOESEMANDAMENTO);

        curriculo.setOrientacoesMestradoEmAndamento(orientacoesMestradoEmAndamentoItens.size());
        curriculo.setOrientacoesDoutoradoEmAndamento(orientacoesDoutoradoEmAndamentoItens.size());
        curriculo.setOrientacoesGraduacaoEmAndamento(orientacoesGraduacaoEmAndamentoItens.size());

        curriculo.setOrientacoesMestradoConcluidas(orientacoesMestradoConcluidasItens.size());
        curriculo.setOrientacoesDoutoradoConcluidas(orientacoesDoutoradoConcluidasItens.size());
        curriculo.setOrientacoesGraduacaoConcluidas(orientacoesGraduacaoConcluidasItens.size());

        curriculo.setParticipacoesBancasMestrado(participacaoMestradoItens.size());
        curriculo.setParticipacoesBancasDoutorado(participacaoDoutoradoItens.size());
        curriculo.setParticipacoesBancasGraduacao(participacaoGraduacaoItens.size());

        
        List<Element> artigos = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", DETALHAMENTODOARTIGO);
        for (Element artigo : artigos) {

            String tituloAnais = artigo.getAttribute(TITULODOPERIODICOOUREVISTA);

            List<Element> qualisList = RecuperaXml.getElementoXml("xmls/qualis.xml", "entry");

            for (Element qualis : qualisList) {
                String nomeQualis = qualis.getAttribute("regex");

                if (tituloAnais.toLowerCase().matches(".*" + nomeQualis.toLowerCase() + ".*")) {
                    String classe = qualis.getAttribute("class");
                    String tipo = qualis.getAttribute("type");

                    curriculo.qualificaArtigos(tipo, classe);
                }
            }
        }
        
        List<Element> eventos = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", DETALHAMENTODOTRABALHO);
        for (Element evento : eventos) {

            String tituloEvento = evento.getAttribute(TITULODOSANAISOUPROCEEDINGS);

            List<Element> qualisList = RecuperaXml.getElementoXml("xmls/qualis.xml", "entry");

            for (Element qualis : qualisList) {
                String nomeQualis = qualis.getAttribute("regex");

                if (tituloEvento.toLowerCase().matches(".*" + nomeQualis.toLowerCase() + ".*")) {
                    String classe = qualis.getAttribute("class");
                    String tipo = qualis.getAttribute("type");

                    curriculo.qualificaArtigos(tipo, classe);
                }
            }
        }

        return curriculo;

        /*                

         List<Element> curriculoElements = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", "root");
        
         if (curriculoElements.isEmpty())
         return curriculo;
        
         Element curriculoElement = curriculoElements.get(0);
        
         LeitorXml.getElements(curriculoElement, "nome");
        
         */
    }

}
