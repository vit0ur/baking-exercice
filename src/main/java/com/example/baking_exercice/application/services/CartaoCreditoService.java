package com.example.baking_exercice.application.services;

import com.example.baking_exercice.application.port.CartaoCreditoRepositoryPort;
import com.example.baking_exercice.domain.CartaoCredito;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartaoCreditoService {
    private final CartaoCreditoRepositoryPort cartaoCreditoRepositoryPort;

    public CartaoCreditoService(CartaoCreditoRepositoryPort cartaoCreditoRepositoryPort) {
        this.cartaoCreditoRepositoryPort = cartaoCreditoRepositoryPort;
    }

    public CartaoCredito cadastrarCartaoCredito(CartaoCredito cartaoCredito){
        return cartaoCreditoRepositoryPort.salvar(cartaoCredito);
    }

    public CartaoCredito atualizarCartaoCredito(CartaoCredito cartaoCredito){
        return cartaoCreditoRepositoryPort.salvar(cartaoCredito);
    }

    public List<CartaoCredito> listarTodos(){
        return cartaoCreditoRepositoryPort.buscarTodos();
    }

    public CartaoCredito buscarPorId(Long id){
        return cartaoCreditoRepositoryPort.buscarPorId(id).orElseThrow(()-> new RuntimeException("cartão de crédito não encontrado."));
    }

    public void deletarCartaoCredito(Long id){
        cartaoCreditoRepositoryPort.deletarPorId(id);
    }

    public List<CartaoCredito> listarPorCliente(Long idCliente) {
        return cartaoCreditoRepositoryPort.listarPorCliente(idCliente);
    }
}