package com.example.baking_exercice.interfaces.dtos;

import com.example.baking_exercice.domain.Cliente;

public record CartaoCreditoResponseDTO(String numero, Double limite, Cliente cliente) {
}