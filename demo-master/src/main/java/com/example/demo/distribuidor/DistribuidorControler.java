package com.example.demo.distribuidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("distribuidores")
public class DistribuidorControler {

    @Autowired
    private DistribuidorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastrodistribuidores dados) {
        repository.save(new Distribuidor(dados));
    }

    @GetMapping("list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ListaDistribuidores> listar() {
        return repository.findAll().stream().map(ListaDistribuidores::new).toList();

    }

}

