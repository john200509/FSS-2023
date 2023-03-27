package com.example.demo.Voluntario;

import com.example.demo.ContatoDisponibilidade.Disponibilidade;
import com.example.demo.ContatoDisponibilidade.MeioContato;
import com.example.demo.Produtores.DadosCadastroProdutores;
import com.example.demo.Produtores.TipoAlimento;
import com.example.demo.usuario.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Table(name = "voluntarios")
@Entity(name = "/Voluntarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CEP;

    @Embedded
    private Disponibilidade disponibilidade;

    @Embedded
    private MeioContato meioContato;


    public Voluntario(DadosCadastroVoluntarios dados) {
        this.nome = dados.nome();
        this.disponibilidade = dados.disponibilidade();
        this.CEP = dados.CEP();
        this.meioContato = dados.meioContato();


    }
}