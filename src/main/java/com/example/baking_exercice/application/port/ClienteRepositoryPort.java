package com.example.baking_exercice.application.port;

import com.example.baking_exercice.domain.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorId(Long id);
    List<Cliente> buscarTodos();
    void deletarPorId(Long id);
}