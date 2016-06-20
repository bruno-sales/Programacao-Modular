/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unirio.modelo;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data
class LinhaPesquisa {

    private @Getter @Setter String nome;
    private @Getter @Setter List<Professor> professores;

    public LinhaPesquisa(String nome) {
        this.nome = nome;
    }

}
