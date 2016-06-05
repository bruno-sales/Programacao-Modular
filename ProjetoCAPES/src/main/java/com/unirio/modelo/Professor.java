package com.unirio.modelo;

import lombok.Data;
public @Data class Professor {

    private String nome;
    private String codigo;
    private Curriculo curriculo;

    public Professor(String nome, String codigo, Curriculo curriculo) {
        this.nome = nome;
        this.codigo = codigo;
        this.curriculo = curriculo;
    }
    
   
    

}
