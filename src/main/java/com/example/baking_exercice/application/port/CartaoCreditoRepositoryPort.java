package com.example.baking_exercice.application.port;

import com.example.baking_exercice.domain.CartaoCredito;
import java.util.List;
import java.util.Optional;

public interface CartaoCreditoRepositoryPort {
    CartaoCredito salvar(CartaoCredito cartaoCredito);
    Optional<CartaoCredito> buscarPorId(Long id);
    List<CartaoCredito> buscarTodos();
    void deletarPorId(Long id);
}