/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.modelo;

import com.unirio.acessorios.RecuperaXml;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * Classe responsável por recuperar os dados dos professores pertencentes a linha de pesquisa informada.
 */
public class LeitorProfessor {

    public List<Professor> recuperaDadosProfessor(String linhaPesquisa) {

        List<Professor> listaProfessores = new ArrayList();

        List<Element> linhasPesquisa = RecuperaXml.getElementoXml("xmls/contents.xml", "linha");

        for (Element lp : linhasPesquisa) {
            String nomeLinhaPesquisa = lp.getAttribute("nome");
            if (nomeLinhaPesquisa.equals(linhaPesquisa)) {
                List<Node> professores = new ArrayList();
                
                Node professor = lp.getFirstChild();
                professores.add(professor);
                
                while(professor.getNextSibling() != null){
                    professor = professor.getNextSibling();
                    professores.add(professor);
                }
                
                professor = lp.getLastChild();
                professores.add(professor);
                
                for (Node p : professores) {
                    if(p.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element e = (Element)p;
                        Professor prof = new Professor(e.getAttribute("nome"), e.getAttribute("codigo"));
                        listaProfessores.add(prof);
                    }
                }

            }
        }

        return listaProfessores;

    }

}
