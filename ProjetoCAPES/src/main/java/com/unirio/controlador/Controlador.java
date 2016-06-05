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
import com.unirio.acessorios.Unzipper;
import java.util.ArrayList;
import java.util.List;
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
        baixarTerceiroArquivo();
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

    public static void baixarSegundoArquivo() {
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

    public static void baixarTerceiroArquivo() {
        String nomePrograma = getNomePrograma();
        List<String> CodigoProfessor = getCodigosProfessores();

        for (String codProfessor : CodigoProfessor) {

            String url = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/" + codProfessor + ".zip";
            String nome = codProfessor + ".zip";
            try {
                Baixador.BaixarArquivo(nome, url);
                Unzipper.unzipFile(nome, codProfessor, "xmls");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getNomePrograma() {

        String nomePrograma = "";

        try {
            File inputFile = new File("xmls/programas.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("programa");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

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

    private static List<String> getCodigosProfessores() {
        List<String> codigos = new ArrayList<>();

        try {
            File inputFile = new File("xmls/contents.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("professor");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String cod = LeitorXml.getStringAttribute(eElement, "codigo");
                    codigos.add(cod);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigos;
    }
}
