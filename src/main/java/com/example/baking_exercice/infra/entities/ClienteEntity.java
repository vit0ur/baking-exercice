package com.example.baking_exercice.infra.entities;

import com.example.baking_exercice.domain.Cliente;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.baking_exercice.infra.entities.CartaoCreditoEntity.convertListCartaoDomainEntity;
import static com.example.baking_exercice.infra.entities.CartaoCreditoEntity.convertListCartaoEntityDomain;

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
        return new Cliente(id, nome, email, convertListCartaoDomainEntity(cartoes));
    }

    public static ClienteEntity fromDomain(Cliente cliente){
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.id = cliente.getId();
        clienteEntity.nome = cliente.getNome();
        clienteEntity.email = cliente.getEmail();
        clienteEntity.cartoes = convertListCartaoEntityDomain(cliente.getCartoes());

        return clienteEntity;
    }

    public static List<Cliente> convertListClientEntityDomain(List<ClienteEntity> clienteEntityList){
        List<Cliente> clienteList = new ArrayList<>();
        clienteEntityList.forEach(clienteEntity -> clienteList.add(clienteEntity.toDomain()));

        return clienteList;
    }
}