package com.example.demo.Voluntario;

import com.example.demo.Produtores.DadosCadastroProdutores;
import com.example.demo.Produtores.Produtor;
import com.example.demo.Produtores.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroVoluntarios dados) {
        repository.save(new Voluntario(dados));
    }

    @GetMapping("list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ListaVoluntarios> listar() {
        return repository.findAll().stream().map(ListaVoluntarios::new).toList();

    }
}