package com.example.baking_exercice.infra.adapters;

import com.example.baking_exercice.application.port.ClienteRepositoryPort;
import com.example.baking_exercice.domain.Cliente;
import com.example.baking_exercice.infra.entities.ClienteEntity;
import com.example.baking_exercice.infra.repositories.ClienteJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.example.baking_exercice.infra.entities.ClienteEntity.convertListClientEntityDomain;

@Repository
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {
    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteJpaRepository.save(ClienteEntity.fromDomain(cliente)).toDomain();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteJpaRepository.findById(id).map(ClienteEntity::toDomain);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteJpaRepository.findAll().stream().map(ClienteEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Cliente> findClientesComLimiteTotalMaiorQue(Double limiteMinimo) {
        return convertListClientEntityDomain(clienteJpaRepository.findClientesComLimiteTotalMaiorQue(limiteMinimo));
    }

    @Override
    public void deletarPorId(Long id) {
        clienteJpaRepository.deleteById(id);
    }
}