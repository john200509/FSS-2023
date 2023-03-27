package com.example.demo.Produtores;

import com.example.demo.ContatoDisponibilidade.MeioContato;
import com.example.demo.Produtores.Produtor;
import com.example.demo.distribuidor.Distribuidor;
import jakarta.persistence.Embedded;

public record ListaProdutores(String instituicao, String CEP,@Embedded MeioContato meioContato) {

    public ListaProdutores(Produtor produtor){
        this(produtor.getCEP(), produtor.getInstituicao(), produtor.getMeioContato());
    }
}
