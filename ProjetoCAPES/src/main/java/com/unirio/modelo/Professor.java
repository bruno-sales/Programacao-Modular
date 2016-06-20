package com.unirio.modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class Professor {

    private @Getter String nome;
    private @Getter @Setter String codigo;
    private @Setter Curriculo curriculo;

    public Professor(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
   
    

}
