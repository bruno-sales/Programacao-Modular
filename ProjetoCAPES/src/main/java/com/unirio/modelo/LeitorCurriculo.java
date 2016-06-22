package com.unirio.modelo;

import com.unirio.acessorios.RecuperaXml;
import com.unirio.acessorios.Constants;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Classe responsável por popular dados do currículo do professor e retornar
 * objeto currículo preenchido.
 */
public class LeitorCurriculo {

    public Curriculo recuperaDadosCurriculo(String codProfessor, int anoInicio, int anoFim) {

        Curriculo curriculo = new Curriculo();

        curriculo.setOrientacoesMestradoConcluidas(contabilizaOcorrenciasAtividadePeriodo(Constants.ORIENTACOESCONCLUIDASPARAMESTRADO, Constants.DADOSBASICOSDEORIENTACOESCONCLUIDASPARAMESTRADO, codProfessor, anoInicio, anoFim));

        curriculo.setOrientacoesDoutoradoConcluidas(contabilizaOcorrenciasAtividadePeriodo(Constants.ORIENTACOESCONCLUIDASPARADOUTORADO, Constants.DADOSBASICOSDEORIENTACOESCONCLUIDASPARADOUTORADO, codProfessor, anoInicio, anoFim));

        curriculo.setParticipacoesBancasMestrado(contabilizaOcorrenciasAtividadePeriodo(Constants.PARTICIPACAOEMBANCADEMESTRADO, Constants.DADOSBASICOSDAPARTICIPACAOEMBANCADEMESTRADO, codProfessor, anoInicio, anoFim));

        curriculo.setParticipacoesBancasDoutorado(contabilizaOcorrenciasAtividadePeriodo(Constants.PARTICIPACAOEMBANCADEDOUTORADO, Constants.DADOSBASICOSDAPARTICIPACAOEMBANCADEDOUTORADO, codProfessor, anoInicio, anoFim));

        curriculo.setParticipacoesBancasGraduacao(contabilizaOcorrenciasAtividadePeriodo(Constants.PARTICIPACAOEMBANCADEGRADUACAO, Constants.DADOSBASICOSDAPARTICIPACAOEMBANCADEGRADUACAO, codProfessor, anoInicio, anoFim));

        curriculo.setOrientacoesMestradoEmAndamento(contabilizaOcorrenciasAtividadePeriodo(Constants.ORIENTACAOEMANDAMENTODEMESTRADO, Constants.DADOSBASICOSDAORIENTACAOEMANDAMENTODEMESTRADO, codProfessor, anoInicio, anoFim));

        curriculo.setOrientacoesDoutoradoEmAndamento(contabilizaOcorrenciasAtividadePeriodo(Constants.ORIENTACAOEMANDAMENTODEDOUTORADO, Constants.DADOSBASICOSDAORIENTACAOEMANDAMENTODEDOUTORADO, codProfessor, anoInicio, anoFim));

        curriculo.setOrientacoesGraduacaoEmAndamento(contabilizaOcorrenciasAtividadePeriodo(Constants.ORIENTACAOEMANDAMENTODEGRADUACAO, Constants.DADOSBASICOSDAORIENTACAOEMANDAMENTODEGRADUACAO, codProfessor, anoInicio, anoFim));

        curriculo.setOrientacoesGraduacaoConcluidas(contabilizaOcorrenciasDeNaturezaAtividadePeriodo(Constants.OUTRASORIENTACOESCONCLUIDAS, Constants.DADOSBASICOSDEOUTRASORIENTACOESCONCLUIDAS, Constants.NATUREZA, Constants.TRABALHODECONCLUSAODECURSOGRADUACAO, codProfessor, anoInicio, anoFim));

        //recupera artigos em eventos
        recuperaArtigo(Constants.TRABALHOEMEVENTOS, Constants.DADOSBASICOSDOTRABALHO, Constants.DETALHAMENTODOTRABALHO, Constants.ANODOTRABALHO, Constants.TITULODOSANAISOUPROCEEDINGS, "conferência", codProfessor, anoInicio, anoFim, curriculo, "evento");

        //recupera artigos em revistas
        recuperaArtigo(Constants.ARTIGOPUBLICADO, Constants.DADOSBASICOSDOARTIGO, Constants.DETALHAMENTODOARTIGO, Constants.ANODOARTIGO, Constants.TITULODOPERIODICOOUREVISTA, "periódico", codProfessor, anoInicio, anoFim, curriculo, "revista");

        return curriculo;
    }

    //Método responsável por contabilizar as atividades de uma dada tag que ocorreram dentro do período especificado
    public int contabilizaOcorrenciasAtividadePeriodo(String tagPai, String tagFilha, String codProfessor, int anoInicio, int anoFim) {

        List<Element> itensTotaisDaAtividade = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", tagPai);
        return RecuperaXml.quantidadeElementosNoPeriodo(itensTotaisDaAtividade, tagFilha, Constants.ANO, anoInicio, anoFim);

    }

    //Método responsável por contabilizar as atividades de uma dada tag que ocorreram dentro do período especificado
    public int contabilizaOcorrenciasDeNaturezaAtividadePeriodo(String tagPai, String tagFilha, String tagNatureza, String valorNatureza, String codProfessor, int anoInicio, int anoFim) {

        List<Element> itensTotaisDaAtividade = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", tagPai);
        return RecuperaXml.quantidadeElementosNaturezaNoPeriodo(itensTotaisDaAtividade, tagFilha, Constants.ANO, tagNatureza, valorNatureza, anoInicio, anoFim);

    }

    //Método responsável por recuperar artigos publicados em revistas datadas do período especificado via parâmetros anoInicio, anoFim
    private void recuperaArtigo(String tagTipoArtigo, String dadosBasicosArtigo, String detalhamentoArtigo, String tagAnoArtigo, String tagTituloArtigo, String tipoArtigo, String codProfessor, int anoInicio, int anoFim, Curriculo curriculo, String mensagemArtigo) {

        List<Element> artigos = RecuperaXml.getElementoXml("xmls/" + codProfessor + "curriculo.xml", tagTipoArtigo);
        for (Element artigo : artigos) {

            NodeList dadosBasicos = artigo.getElementsByTagName(dadosBasicosArtigo);
            NodeList detalhemento = artigo.getElementsByTagName(detalhamentoArtigo);

            Element elementDadosBasicos = (Element) dadosBasicos.item(0);
            Element elementDetalhemento = (Element) detalhemento.item(0);

            String stringAnoDoArtigo = elementDadosBasicos.getAttribute(tagAnoArtigo);
            String tituloArtigoRevista = elementDetalhemento.getAttribute(tagTituloArtigo);

            if (!stringAnoDoArtigo.isEmpty()) {

                int anoDoArtigo = Integer.parseInt(stringAnoDoArtigo);
                if ((anoDoArtigo >= anoInicio) && (anoDoArtigo <= anoFim)) {

                    List<Element> qualisList = RecuperaXml.getElementoXml("xmls/qualis.xml", "entry");
                    int countMatchesRevista = 0;

                    for (Element qualis : qualisList) {
                        String padrao = qualis.getAttribute("regex");
                        String tipo = qualis.getAttribute("type");

                        if (tituloArtigoRevista.matches("(?i:.*" + padrao + ".*)")
                                && tipo.toLowerCase().equals(tipoArtigo)) {
                            countMatchesRevista++;

                            String classe = qualis.getAttribute("class");

                            curriculo.qualificaArtigos(tipo, classe);
                            break;
                        }
                    }
                    if (countMatchesRevista == 0) {
                        System.out.println("Artigo em " + mensagemArtigo + " não encontrado: " + tituloArtigoRevista);
                    }

                }
            }

        }

    }

}
