package com.example.demo.Coletor;

import com.example.demo.ContatoDisponibilidade.Disponibilidade;
import com.example.demo.ContatoDisponibilidade.MeioContato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "coletores")
@Entity(name = "Coletores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coletor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String CPF;
    private String CEP;

    @Embedded
    Disponibilidade disponibilidade;

    @Embedded
    MeioContato meioContato;

    public Coletor(DadosCadastroColetor dados) {
        this.nome = dados.nome();
        this.CPF = dados.CPF();
        this.CEP = dados.CEP();
        this.disponibilidade = dados.disponibilidade();
        this.meioContato = dados.meioContato();
    }
}
