package com.example.demo.Produtores;

import com.example.demo.ContatoDisponibilidade.MeioContato;
import jakarta.persistence.Embedded;

public record DadosCadastroProdutores(String instituicao, String CNPJ, String CEP,String quantidadeKg, TipoAlimento tipoAlimento, @Embedded MeioContato meioContato) {
}
