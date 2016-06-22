/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.modelo;

import com.unirio.acessorios.LeitorXml;
import com.unirio.acessorios.RecuperaXml;
import java.util.List;
import org.w3c.dom.Element;

/**
 * Classe responsável por instanciar objetos do tipo Programa recuperados do arquivo programas.xml.
 */
public class LeitorPrograma {

    public Programa recuperaDadosPrograma(String nomePrograma) {

        Programa programaEscolhido = new Programa();

        List<Element> programas = RecuperaXml.getElementoXml("xmls/programas.xml", "programa");

        for (Element programa : programas) {
            Programa p = new Programa(LeitorXml.getStringAttribute(programa, "nome"));
            if(p.getNome().equals(nomePrograma))
                programaEscolhido = p;
        }
        
        return programaEscolhido;
        
        

    }

}
