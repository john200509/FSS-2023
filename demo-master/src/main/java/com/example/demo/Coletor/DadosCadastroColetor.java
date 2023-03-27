package com.example.demo.Coletor;

import com.example.demo.ContatoDisponibilidade.Disponibilidade;
import com.example.demo.ContatoDisponibilidade.MeioContato;
import jakarta.persistence.Embedded;

public record DadosCadastroColetor(String nome, String CPF, String CEP, Disponibilidade disponibilidade, @Embedded  MeioContato meioContato) {
}
