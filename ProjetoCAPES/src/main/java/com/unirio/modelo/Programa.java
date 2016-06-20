package com.unirio.modelo;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class Programa {

    private @Getter String nome;
    private @Getter @Setter List<LinhaPesquisa> linhasPesquisa; 

    public Programa(String nome) {
        this.nome = nome;
    }
    
    public Programa(){
    
    }

}
