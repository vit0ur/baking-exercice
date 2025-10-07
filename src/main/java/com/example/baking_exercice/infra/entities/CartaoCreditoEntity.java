package com.example.baking_exercice.infra.entities;

import com.example.baking_exercice.domain.CartaoCredito;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CartaoCreditoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Double limite;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity cliente;

    public CartaoCredito toDomain(){
        return new CartaoCredito(id, numero, limite, cliente.toDomain());
    }

    public static CartaoCreditoEntity fromDomain(CartaoCredito cartaoCredito){
        CartaoCreditoEntity cartaoCreditoEntity = new CartaoCreditoEntity();

        cartaoCreditoEntity.id = cartaoCredito.getId();
        cartaoCreditoEntity.numero = cartaoCredito.getNumero();
        cartaoCreditoEntity.limite = cartaoCredito.getLimite();
        cartaoCreditoEntity.cliente = ClienteEntity.fromDomain(cartaoCredito.getCliente());

        return cartaoCreditoEntity;
    }

    public static List<CartaoCredito> convertListDomainEntity (List<CartaoCreditoEntity> cartaoCreditoEntityList){
        List<CartaoCredito> cartaoCreditoList = new ArrayList<>();
        cartaoCreditoEntityList.forEach(cartaoCreditoEntity -> cartaoCreditoList.add(cartaoCreditoEntity.toDomain()));

        return cartaoCreditoList;
    }

    public static  List<CartaoCreditoEntity> convertListEntityDomain (List<CartaoCredito> cartaoCreditoList){
        List<CartaoCreditoEntity> cartaoCreditoEntityList = new ArrayList<>();
        cartaoCreditoList.forEach(cartaoCredito -> cartaoCreditoEntityList.add(fromDomain(cartaoCredito)));

        return cartaoCreditoEntityList;
    }
}