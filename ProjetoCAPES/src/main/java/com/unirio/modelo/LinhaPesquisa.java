/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.modelo;

import lombok.Data;
import lombok.Getter;

/**
 *
 * @author Caroline
 */
public @Data
class LinhaPesquisa {

    private @Getter String nome;

    public LinhaPesquisa(String nome) {
        this.nome = nome;
    }

}
