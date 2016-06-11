package com.unirio.modelo;

import lombok.Data;
import lombok.Getter;

public @Data class Programa {

    private @Getter String nome;

    public Programa(String nome) {
        this.nome = nome;
    }

}
