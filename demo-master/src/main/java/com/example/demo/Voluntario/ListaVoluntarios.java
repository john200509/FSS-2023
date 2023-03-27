package com.example.demo.Voluntario;

import com.example.demo.ContatoDisponibilidade.Disponibilidade;
import com.example.demo.ContatoDisponibilidade.MeioContato;
import jakarta.persistence.Embedded;

public record ListaVoluntarios(String nome,@Embedded Disponibilidade disponibilidade, String CEP, @Embedded MeioContato meioContato) {

    public ListaVoluntarios(Voluntario voluntario){
        this(voluntario.getNome(), voluntario.getDisponibilidade(),voluntario.getCEP(), voluntario.getMeioContato());
    }
}
