package com.example.demo.usuario.cliente;

public record ListaCliente(String nome, String email) {

    public ListaCliente (Cliente cliente){
        this(cliente.getNome(), cliente.getEmail());
    }
}
