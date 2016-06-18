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

    private static final String ARTIGOPUBLICADO = "ARTIGO-PUBLICADO";
    private static final String TITULODOPERIODICOOUREVISTA = "TITULO-DO-PERIODICO-OU-REVISTA";

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

        int artigosRevistasA1 = 0;
        int artigosRevistasA2 = 0;
        int artigosRevistasB1 = 0;
        int artigosRevistasB2 = 0;
        int artigosRevistasB3 = 0;
        int artigosRevistasB4 = 0;
        int artigosRevistasC = 0;
        int artigosRevistasNC = 0;
        int artigosEventosA1 = 0;
        int artigosEventosA2 = 0;
        int artigosEventosB1 = 0;
        int artigosEventosB2 = 0;
        int artigosEventosB3 = 0;
        int artigosEventosB4 = 0;
        int artigosEventosC = 0;
        int artigosEventosNC = 0;

        List<Element> artigos = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", ARTIGOPUBLICADO);

        for (Element artigo : artigos) {

            NodeList algo = artigo.getElementsByTagName("DETALHAMENTO-DO-ARTIGO");

            String tituloEvento = artigo.getAttribute(TITULODOPERIODICOOUREVISTA);

            List<Element> qualisList = RecuperaXml.getElementoXml("xmls/qualis.xml", "entry");

            for (Element qualis : qualisList) {
                String nomeQualis = qualis.getAttribute("regex");

                if (tituloEvento.toLowerCase() == nomeQualis.toLowerCase()) {
                    String classe = qualis.getAttribute("class");
                    String tipo = qualis.getAttribute("type");

                    if (tipo.equals("Periódico")) {
                        switch (classe) {
                            case "A1":
                                artigosRevistasA1++;
                                break;
                            case "A2":
                                artigosRevistasA2++;
                                break;
                            case "B1":
                                artigosRevistasB1++;
                                break;
                            case "B2":
                                artigosRevistasB2++;
                                break;
                            case "B3":
                                artigosRevistasB3++;
                                break;
                            case "B4":
                                artigosRevistasB4++;
                                break;
                            case "C":
                                artigosRevistasC++;
                                break;
                            case "NC":
                                artigosRevistasNC++;
                                break;
                            default:
                                break;
                        }
                    } else {
                        switch (classe) {
                            case "A1":
                                artigosEventosA1++;
                                break;
                            case "A2":
                                artigosEventosA2++;
                                break;
                            case "B1":
                                artigosEventosB1++;
                                break;
                            case "B2":
                                artigosEventosB2++;
                                break;
                            case "B3":
                                artigosEventosB3++;
                                break;
                            case "B4":
                                artigosEventosB4++;
                                break;
                            case "C":
                                artigosEventosC++;
                                break;
                            case "NC":
                                artigosEventosNC++;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }

        curriculo.setArtigosEventosA1(artigosEventosA1);
        curriculo.setArtigosEventosA2(artigosEventosA2);
        curriculo.setArtigosEventosB1(artigosEventosB1);
        curriculo.setArtigosEventosB2(artigosEventosB2);
        curriculo.setArtigosEventosB3(artigosEventosB3);
        curriculo.setArtigosEventosB4(artigosEventosB4);
        curriculo.setArtigosEventosC(artigosEventosC);
        curriculo.setArtigosEventosNC(artigosEventosNC);

        curriculo.setArtigosRevistasA1(artigosRevistasA1);
        curriculo.setArtigosRevistasA2(artigosRevistasA2);
        curriculo.setArtigosRevistasB1(artigosRevistasB1);
        curriculo.setArtigosRevistasB2(artigosRevistasB2);
        curriculo.setArtigosRevistasB3(artigosRevistasB3);
        curriculo.setArtigosRevistasB4(artigosRevistasB4);
        curriculo.setArtigosRevistasC(artigosRevistasC);
        curriculo.setArtigosRevistasNC(artigosRevistasNC);

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
