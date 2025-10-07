package com.example.baking_exercice.interfaces.dtos;

import com.example.baking_exercice.domain.Cliente;
import jakarta.validation.constraints.NotBlank;

public record CartaoCreditoRequestDTO(
            Long id,

            @NotBlank(message = "número é obrigatório!")
            String numero,

            @NotBlank(message = "limite é obrigatório!")
            Double limite,

            @NotBlank(message = "limite é obrigatório!")
            Cliente cliente
        ) {
}