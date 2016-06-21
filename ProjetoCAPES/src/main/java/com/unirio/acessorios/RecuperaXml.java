package com.unirio.acessorios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RecuperaXml {
    /* Recupera Elementos de um arquivo associados a tag tagName*/

    public static List<Element> getElementoXml(String nomeArquivo, String tagName) {
        List<Element> elementos = new ArrayList<>();

        try {
            File inputFile = new File(nomeArquivo);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(tagName);

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    elementos.add(eElement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return elementos;
    }

    public static int quantidadeElementosNoAno(List<Element> elements, String tagFilho, String tagAno, int anoInicio, int anoFim) {
        
        int contador = 0;
        
        for (Element element : elements) {
            NodeList detalhemento = element.getElementsByTagName(tagFilho);
            Element elementDadosBasicos = (Element) detalhemento.item(0);

            String stringAno = elementDadosBasicos.getAttribute(tagAno);

            int ano = Integer.parseInt(stringAno);

            if (ano >= anoInicio && ano <= anoFim) {
                contador++;
            }
        }
        return contador;
    }
}
