package com.example.baking_exercice.infra.repositories;

import com.example.baking_exercice.infra.entities.CartaoCreditoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoJpaRepository extends JpaRepository<CartaoCreditoEntity, Long> {
}