package com.example.baking_exercice.infra.repositories;

import com.example.baking_exercice.infra.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
    @Query("SELECT c FROM Cliente c JOIN c.cartoes cc GROUP BY c.id HAVING SUM(cc.limite) > :limiteMinimo")
    List<ClienteEntity> findClientesComLimiteTotalMaiorQue(@Param("limiteMinimo") Double limiteMinimo);
}