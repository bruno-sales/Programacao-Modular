/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.modelo;

import static com.unirio.acessorios.Baixador.BaixarArquivo;
import com.unirio.acessorios.LeitorXml;
import com.unirio.acessorios.RecuperaXml;
import com.unirio.controlador.Controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;

/**
 *
 * Classe responsável por instanciar objetos do tipo Programa recuperados do arquivo programas.xml.
 */
public class LeitorPrograma {

    public static List<Programa> recuperaDadosPrograma() {

        List<Programa> listaProgramas = new ArrayList();

        List<Element> programas = RecuperaXml.getElementoXml("xmls/programas.xml", "programa");

        for (Element programa : programas) {
            Programa p = new Programa(LeitorXml.getStringAttribute(programa, "nome"));
            listaProgramas.add(p);
        }
        
        return listaProgramas;
        
        

    }

}
