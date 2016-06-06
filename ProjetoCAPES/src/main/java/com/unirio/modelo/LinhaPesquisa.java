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
import lombok.Data;


/**
 *
 * @author Caroline
 */
public @Data class LinhaPesquisa {
    
        private String nome;

    public LinhaPesquisa(String nome) {
        this.nome = nome;
    }
        
        
    
}
