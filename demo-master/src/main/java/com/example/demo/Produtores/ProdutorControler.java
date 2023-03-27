package com.example.demo.Produtores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtores")
public class ProdutorControler {

    @Autowired
    private ProdutorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroProdutores dados) {
        repository.save(new Produtor(dados));
    }

    @GetMapping("list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ListaProdutores> listar() {
        return repository.findAll().stream().map(ListaProdutores::new).toList();

    }

}
