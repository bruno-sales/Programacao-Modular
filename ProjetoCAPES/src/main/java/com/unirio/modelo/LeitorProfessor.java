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
 * @author Caroline
 */
public class LeitorProfessor {
    
    public static List<Professor> recuperaDadosProfessor() {
        
        List<Professor> listaProfessores = new ArrayList();

        List<Element> professores = RecuperaXml.getElementoXml("xmls/contents.xml" , "professor");

        for (Element professor : professores) {
            Professor p = new Professor(LeitorXml.getStringAttribute(professor, "nome"),LeitorXml.getStringAttribute(professor, "codigo"));
            listaProfessores.add(p);
        }
        
        return listaProfessores;
        
        

    }

    
}
