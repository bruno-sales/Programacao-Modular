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

/**
 *
 * Classe responsável por popular linhas de pesquisa do programa informado
 */
public class LeitorLinhaPesquisa {
    
    public static List<LinhaPesquisa> recuperaDadosLinhaPesquisa(Programa programa) {

        //TO-DO: generalizar para que qualquer programa possa ser acessado. Estrutura do nome.
        List<LinhaPesquisa> listaLinhasPesquisa = new ArrayList();

        List<Element> linhasPesquisa = RecuperaXml.getElementoXml("xmls/contents.xml" , "linha");

        for (Element linhaPesquisa : linhasPesquisa) {
            LinhaPesquisa lp = new LinhaPesquisa(LeitorXml.getStringAttribute(linhaPesquisa, "nome"));
            listaLinhasPesquisa.add(lp);
        }
        
        return listaLinhasPesquisa;
        
        

    }
    
}
