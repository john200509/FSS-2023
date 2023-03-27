package com.example.demo.reserva;

import com.example.demo.Produtores.TipoAlimento;
import jakarta.persistence.Embedded;

public record DadosReserva (String nome, String hora, String instituicao, String alimento) {

}
