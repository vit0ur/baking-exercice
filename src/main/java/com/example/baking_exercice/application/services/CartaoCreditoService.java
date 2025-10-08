package com.example.baking_exercice.application.services;

import com.example.baking_exercice.application.port.CartaoCreditoRepositoryPort;
import com.example.baking_exercice.application.port.ClienteRepositoryPort;
import com.example.baking_exercice.domain.CartaoCredito;
import com.example.baking_exercice.domain.Cliente;
import com.example.baking_exercice.interfaces.dtos.CartaoCreditoResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartaoCreditoService {
    private final CartaoCreditoRepositoryPort cartaoCreditoRepositoryPort;
    private final ClienteRepositoryPort clienteRepositoryPort;

    public CartaoCreditoService(CartaoCreditoRepositoryPort cartaoCreditoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        this.cartaoCreditoRepositoryPort = cartaoCreditoRepositoryPort;
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    public CartaoCredito cadastrarCartaoCredito(CartaoCredito cartaoCredito){

        Long idCliente = cartaoCredito.getCliente().getId();
        Cliente cliente = clienteRepositoryPort.buscarPorId(idCliente).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + idCliente));

        cartaoCredito.setCliente(cliente);

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

    public static CartaoCreditoResponseDTO toResponseDTO(CartaoCredito cartao) {
        return new CartaoCreditoResponseDTO(cartao.getNumero(), cartao.getLimite(), cartao.getCliente());
    }
}