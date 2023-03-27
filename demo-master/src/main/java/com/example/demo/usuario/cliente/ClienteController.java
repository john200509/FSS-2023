package com.example.demo.usuario.cliente;


import com.example.demo.Produtores.ProdutorRepository;
import com.example.demo.Role.Role;
import com.example.demo.Role.RoleRepository;
import com.example.demo.Security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ProdutorRepository repository;



    @PostMapping
    @RequestMapping("cadastrar")
    public ResponseEntity cadastrar(@RequestBody DadosCadastroCliente dados) {
        Cliente c = new Cliente(dados);
        c.setSenha(passwordEncoder.encode(c.getSenha()));

        Role role = roleRepository.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        c.setRoles(roleSet);
        clienteRepository.save(c);
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Cliente) authentication.getPrincipal()));
    }


    @PostMapping
    @RequestMapping("login")
    public ResponseEntity Login(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Cliente) authentication.getPrincipal()));
    }

    @PostMapping
    @RequestMapping("loginAdm")
    public ResponseEntity LoginAdm(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Cliente) authentication.getPrincipal()));
    }


    @GetMapping("list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ListaCliente> listar() {
        return clienteRepository.findAll().stream().map(ListaCliente::new).toList();

        }

    @GetMapping("/{id}")
    public Cliente listar(@PathVariable Long id) {
        return clienteRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public void excluir(@PathVariable Long id) {
        clienteRepository.deleteById(id);

    }

}
