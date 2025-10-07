package com.example.baking_exercice.infra.entities;

import com.example.baking_exercice.domain.Cliente;
import jakarta.persistence.*;
import java.util.List;
import static com.example.baking_exercice.infra.entities.CartaoCreditoEntity.convertListDomainEntity;
import static com.example.baking_exercice.infra.entities.CartaoCreditoEntity.convertListEntityDomain;

@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartaoCreditoEntity> cartoes;

    public Cliente toDomain(){
        return new Cliente(id, nome, email, convertListDomainEntity(cartoes));
    }

    public static ClienteEntity fromDomain(Cliente cliente){
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.id = cliente.getId();
        clienteEntity.nome = cliente.getNome();
        clienteEntity.email = cliente.getEmail();
        clienteEntity.cartoes = convertListEntityDomain(cliente.getCartoes());

        return clienteEntity;
    }
}