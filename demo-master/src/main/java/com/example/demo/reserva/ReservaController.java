package com.example.demo.reserva;

import com.example.demo.Produtores.Produtor;
import com.example.demo.Security.TokenService;
import com.example.demo.Voluntario.DadosCadastroVoluntarios;
import com.example.demo.Voluntario.Voluntario;
import com.example.demo.Voluntario.VoluntarioRepository;
import com.example.demo.usuario.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosReserva dados) {
        repository.save(new Reserva(dados));
    }

}