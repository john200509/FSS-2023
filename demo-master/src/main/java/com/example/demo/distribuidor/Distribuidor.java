package com.example.demo.distribuidor;

import com.example.demo.ContatoDisponibilidade.MeioContato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "distribuidores")
@Entity(name = "Distribuidores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Distribuidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instituicao;
    private String CNPJ;
    private String CEP;
    private String RedesSociais;

    @Embedded
    private MeioContato meioContato;


    public Distribuidor(DadosCadastrodistribuidores dados) {
        this.instituicao = dados.instituicao();
        this.CNPJ = dados.CNPJ();
        this.CEP = dados.CEP();
        this.RedesSociais = dados.RedesSociais();
        this.meioContato = dados.meioContato();
    }
}
