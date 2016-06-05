/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.controlador;

import com.unirio.acessorios.Baixador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.unirio.acessorios.LeitorXml;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Classe de controller. Coloquei o metodo main aqui
 */
public class Controlador {

    public static void main(String[] args) {

        baixarPrimeiroArquivo();
        baixarSegundoArquivo();
    }

    public static void baixarPrimeiroArquivo() {
        String url = "https://s3.amazonaws.com/posgraduacao/programas.xml";
        String nome = "programas.xml";

        System.out.print("Nada");

        try {
            Baixador.BaixarArquivo(nome, url);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void baixarSegundoArquivo() 
    {
        String nomePrograma = getNomePrograma();

        String url = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/contents.xml";
        String nome = "contents.xml";

        try {
            Baixador.BaixarArquivo(nome, url);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getNomePrograma() {
        
        String nomePrograma = "";

        try {
            File inputFile = new File("Xmls/programas.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
            Document doc = dBuilder.parse(inputFile);
            
            doc.getDocumentElement().normalize();

            String nome = doc.getDocumentElement().getNodeName();
            System.out.println("Root element :" + nome);

            NodeList nList = doc.getElementsByTagName("programa");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :"
                        + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    nomePrograma = LeitorXml.getStringAttribute(eElement, "nome");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nomePrograma;
    }
}
