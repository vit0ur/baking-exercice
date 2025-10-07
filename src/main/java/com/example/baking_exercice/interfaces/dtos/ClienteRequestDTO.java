package com.example.baking_exercice.interfaces.dtos;

import com.example.baking_exercice.domain.CartaoCredito;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public record ClienteRequestDTO(
            Long id,

            @NotBlank(message = "nome é obrigatório!")
            String nome,

            @Email(message = "insira um endereço de email válido.")
            @NotBlank(message = "email é obrigatório!")
            String email,

            List<CartaoCredito> cartoes
        ) {
}