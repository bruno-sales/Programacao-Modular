package com.unirio.modelo;

import lombok.Data;
public @Data class Professor {

    private String nome;
    private String codigo;

    public Professor(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

}
