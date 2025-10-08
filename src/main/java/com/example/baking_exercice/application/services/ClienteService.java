package com.example.baking_exercice.application.services;

import com.example.baking_exercice.application.port.CartaoCreditoRepositoryPort;
import com.example.baking_exercice.application.port.ClienteRepositoryPort;
import com.example.baking_exercice.domain.CartaoCredito;
import com.example.baking_exercice.domain.Cliente;
import com.example.baking_exercice.exceptions.ResourceNotFoundException;
import com.example.baking_exercice.interfaces.dtos.ClienteResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepositoryPort clienteRepositoryPort;
    private final CartaoCreditoRepositoryPort cartaoCreditoRepositoryPort;

    public ClienteService(ClienteRepositoryPort clienteRepositoryPort, CartaoCreditoRepositoryPort cartaoCreditoRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
        this.cartaoCreditoRepositoryPort = cartaoCreditoRepositoryPort;
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return clienteRepositoryPort.salvar(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente){
        return clienteRepositoryPort.salvar(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepositoryPort.buscarTodos();
    }

    public Cliente buscarPorId(Long id){
        return clienteRepositoryPort.buscarPorId(id).orElseThrow(()-> new ResourceNotFoundException("cliente não encontrado!"));
    }

    public void deletarCliente(Long id){
        List<CartaoCredito> cartaoCreditoList = cartaoCreditoRepositoryPort.listarPorCliente(id);

        if (!cartaoCreditoList.isEmpty()) {
            throw new IllegalStateException("Não é possível deletar o cliente. Existem cartões associados.");
        }

        clienteRepositoryPort.deletarPorId(id);
    }

    public List<Cliente> listarClientesComLimiteTotalMaiorQue(Double limite) {
        return clienteRepositoryPort.findClientesComLimiteTotalMaiorQue(limite);
    }

    public static ClienteResponseDTO toResponseDTO(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getNome(), cliente.getEmail(), cliente.getCartoes());
    }
}