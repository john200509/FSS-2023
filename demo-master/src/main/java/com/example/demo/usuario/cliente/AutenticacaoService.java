package com.example.demo.usuario.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private ClienteRepository reposiory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return reposiory.findByEmail(username);
    }
}
