package com.example.demo.Coletor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coletores")
public class ColetorControler {

    @Autowired
    private ColetorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroColetor dados) {
        repository.save(new Coletor(dados));
    }
    @GetMapping("list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ListaColetores> listar() {
        return repository.findAll().stream().map(ListaColetores::new).toList();

    }
}
