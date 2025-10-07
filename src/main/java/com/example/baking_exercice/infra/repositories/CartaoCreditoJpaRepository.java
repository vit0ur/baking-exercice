package com.example.baking_exercice.infra.repositories;

import com.example.baking_exercice.infra.entities.CartaoCreditoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartaoCreditoJpaRepository extends JpaRepository<CartaoCreditoEntity, Long> {
    List<CartaoCreditoEntity> findByClienteId(Long idCliente);
}