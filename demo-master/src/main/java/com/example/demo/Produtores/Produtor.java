package com.example.demo.Produtores;

import com.example.demo.ContatoDisponibilidade.MeioContato;
import com.example.demo.usuario.cliente.DadosCadastroCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtores")
@Entity(name = "/Produtores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instituicao;
    private String CNPJ;
    private String CEP;
    private String quantidadeKg;

    @Enumerated(EnumType.STRING)
    private TipoAlimento tipoAlimento;

    private MeioContato meioContato;



    public Produtor(DadosCadastroProdutores dados){
        this.instituicao = dados.instituicao();
        this.CNPJ = dados.CNPJ();
        this.CEP = dados.CEP();
        this.quantidadeKg = dados.quantidadeKg();
        this.tipoAlimento = dados.tipoAlimento();
        this.meioContato = dados.meioContato();

    }


}
