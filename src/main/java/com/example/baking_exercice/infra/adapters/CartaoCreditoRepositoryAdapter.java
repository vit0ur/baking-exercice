package com.example.baking_exercice.infra.adapters;

import com.example.baking_exercice.application.port.CartaoCreditoRepositoryPort;
import com.example.baking_exercice.domain.CartaoCredito;
import com.example.baking_exercice.infra.entities.CartaoCreditoEntity;
import com.example.baking_exercice.infra.repositories.CartaoCreditoJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.example.baking_exercice.infra.entities.CartaoCreditoEntity.convertListCartaoDomainEntity;

@Repository
public class CartaoCreditoRepositoryAdapter implements CartaoCreditoRepositoryPort {

    private final CartaoCreditoJpaRepository cartaoCreditoJpaRepository;

    public CartaoCreditoRepositoryAdapter(CartaoCreditoJpaRepository cartaoCreditoJpaRepository) {
        this.cartaoCreditoJpaRepository = cartaoCreditoJpaRepository;
    }

    @Override
    public CartaoCredito salvar(CartaoCredito cartaoCredito) {
        return cartaoCreditoJpaRepository.save(CartaoCreditoEntity.fromDomain(cartaoCredito)).toDomain();
    }

    @Override
    public Optional<CartaoCredito> buscarPorId(Long id) {
        return cartaoCreditoJpaRepository.findById(id).map(CartaoCreditoEntity::toDomain);
    }

    @Override
    public List<CartaoCredito> buscarTodos() {
        return cartaoCreditoJpaRepository.findAll().stream().map(CartaoCreditoEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<CartaoCredito> listarPorCliente(Long idCliente) {
        return convertListCartaoDomainEntity(cartaoCreditoJpaRepository.findByClienteId(idCliente));
    }

    @Override
    public void deletarPorId(Long id) {
        cartaoCreditoJpaRepository.deleteById(id);
    }
}