package com.example.demo.distribuidor;

import com.example.demo.ContatoDisponibilidade.MeioContato;

public record ListaDistribuidores(String instituicao, String CEP, MeioContato meioContato) {

    public ListaDistribuidores (Distribuidor distribuidor){
        this(distribuidor.getInstituicao(), distribuidor.getCEP(), distribuidor.getMeioContato());
    }
}
