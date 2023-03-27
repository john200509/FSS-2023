package com.example.demo.distribuidor;

import com.example.demo.ContatoDisponibilidade.MeioContato;
import jakarta.persistence.Embedded;

public record DadosCadastrodistribuidores(String instituicao, String CNPJ, String CEP, String RedesSociais, @Embedded MeioContato meioContato) {
}
