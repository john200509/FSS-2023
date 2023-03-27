package com.example.demo.Coletor;

import com.example.demo.ContatoDisponibilidade.Disponibilidade;
import com.example.demo.ContatoDisponibilidade.MeioContato;

public record ListaColetores(String nome, String CPF, String CEP, Disponibilidade disponibilidade, MeioContato meioContato) {

    public ListaColetores (Coletor coletor){
        this(coletor.getNome(), coletor.getCPF(), coletor.getCEP(), coletor.getDisponibilidade(), coletor.getMeioContato());
    }
}
