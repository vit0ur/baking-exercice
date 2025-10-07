package com.example.baking_exercice.infra.repositories;

import com.example.baking_exercice.infra.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
}