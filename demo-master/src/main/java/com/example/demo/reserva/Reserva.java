package com.example.demo.reserva;


import com.example.demo.ContatoDisponibilidade.Disponibilidade;
import com.example.demo.ContatoDisponibilidade.MeioContato;
import com.example.demo.Produtores.TipoAlimento;
import com.example.demo.Voluntario.DadosCadastroVoluntarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "reservas")
@Entity(name = "/Reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String hora;
    private String instituicao;
    private String alimento;

    @Embedded
    private TipoAlimento tipoAlimento;

    public Reserva(DadosReserva dados) {
        this.alimento = dados.alimento();
        this.nome = dados.nome();
        this.instituicao = dados.instituicao();
        this.hora = dados.hora();


    }
}



