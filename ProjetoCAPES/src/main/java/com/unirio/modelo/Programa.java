package com.unirio.modelo;

import lombok.Data;

public @Data class Programa {

    private String nome;

    public Programa(String nome) {
        this.nome = nome;
    }

}
