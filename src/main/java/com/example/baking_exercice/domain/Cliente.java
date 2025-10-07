package com.example.baking_exercice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private List<CartaoCredito> cartoes;
}