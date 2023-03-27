package com.example.demo.ContatoDisponibilidade;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Disponibilidade {

    private String dia;
    private String periodo;

    public Disponibilidade(Disponibilidade dados) {
        this.dia = dados.dia;
        this.periodo = dados.periodo;
    }
}
