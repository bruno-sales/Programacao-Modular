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
 * Classe responsável por popular dados do currículo do professor e retornar objeto currículo preenchido.
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
    private static final String ANODOARTIGO = "ANO-DO-ARTIGO";
    private static final String ARTIGOPUBLICADO = "ARTIGO-PUBLICADO";
    
    private static final String TRABALHOEMEVENTOS = "TRABALHO-EM-EVENTOS";
        private static final String ANODOTRABALHO = "ANO-DO-TRABALHO";


    private static final String TITULODOSANAISOUPROCEEDINGS = "TITULO-DOS-ANAIS-OU-PROCEEDINGS";

    
    public static Curriculo recuperaDadosCurriculo(String codProfessor, int anoInicio, int anoFim) {

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

        List<Element> artigos = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", ARTIGOPUBLICADO);
        for (Element artigo : artigos) {
            
            String tituloArtigoRevista = artigo.getAttribute(TITULODOPERIODICOOUREVISTA);
            String stringAnoDoArtigo = artigo.getAttribute(ANODOARTIGO);
            
            if(!stringAnoDoArtigo.isEmpty()){
                
                int anoDoArtigo = Integer.parseInt(stringAnoDoArtigo);
                if((anoDoArtigo>=anoInicio)&&(anoDoArtigo<=anoFim)){

                    List<Element> qualisList = RecuperaXml.getElementoXml("xmls/qualis.xml", "entry");
                    int countMatchesRevista = 0;

                    for (Element qualis : qualisList) {
                        String padrao = qualis.getAttribute("regex");
                        if (tituloArtigoRevista.matches("(?i:.*" + padrao + ".*)")) {
                            countMatchesRevista++;

                            String classe = qualis.getAttribute("class");
                            String tipo = qualis.getAttribute("type");

                            curriculo.qualificaArtigos(tipo, classe);
                        }
                    }
                    if (countMatchesRevista == 0) {
                        System.out.println("Artigo em revista não encontrado: " + tituloArtigoRevista);
                    }

                }
            }
            
        }

        List<Element> eventos = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", TRABALHOEMEVENTOS);
        for (Element evento : eventos) {

            String tituloArtigoEventos = evento.getAttribute(TITULODOSANAISOUPROCEEDINGS);
            String stringAnoDoTrabalho = evento.getAttribute(ANODOTRABALHO);

            if(!stringAnoDoTrabalho.isEmpty()){
                
                int anoDoTrabalho = Integer.parseInt(stringAnoDoTrabalho);
                if((anoDoTrabalho>=anoInicio)&&(anoDoTrabalho<=anoFim)){
                    List<Element> qualisList = RecuperaXml.getElementoXml("xmls/qualis.xml", "entry");
                    int countMatchesEventos = 0;

                    for (Element qualis : qualisList) {
                        String padrao = qualis.getAttribute("regex");

                        if (tituloArtigoEventos.matches("(?i:.*"+ padrao + ".*)")) {
                            countMatchesEventos++;
                            String classe = qualis.getAttribute("class");
                            String tipo = qualis.getAttribute("type");

                            curriculo.qualificaArtigos(tipo, classe);
                        }
                    }
                    if (countMatchesEventos == 0) {
                        System.out.println("Artigo em evento não encontrado: " + tituloArtigoEventos);
                    }
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
