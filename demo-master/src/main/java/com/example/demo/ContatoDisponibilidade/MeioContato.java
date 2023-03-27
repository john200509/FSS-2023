package com.example.demo.ContatoDisponibilidade;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeioContato {

    private String email;
    private String telefone;
}
