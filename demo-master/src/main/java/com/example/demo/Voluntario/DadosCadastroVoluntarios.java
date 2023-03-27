package com.example.demo.Voluntario;

import com.example.demo.ContatoDisponibilidade.Disponibilidade;
import com.example.demo.ContatoDisponibilidade.MeioContato;
import jakarta.persistence.Embedded;

public record DadosCadastroVoluntarios (String nome,@Embedded Disponibilidade disponibilidade, String CEP, @Embedded MeioContato meioContato) {
}
