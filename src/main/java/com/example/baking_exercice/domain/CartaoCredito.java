package com.example.baking_exercice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartaoCredito {
    private Long id;
    private String numero;
    private Double limite;
    private Cliente cliente;
}