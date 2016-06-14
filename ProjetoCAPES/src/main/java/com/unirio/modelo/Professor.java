package com.unirio.modelo;

import lombok.Data;
import lombok.Getter;
public @Data class Professor {

    private @Getter String nome;
    private String codigo;
    private Curriculo curriculo;

    public Professor(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
   
    

}
