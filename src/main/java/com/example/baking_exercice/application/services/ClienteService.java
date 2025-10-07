package com.example.baking_exercice.application.services;

import com.example.baking_exercice.application.port.ClienteRepositoryPort;
import com.example.baking_exercice.domain.Cliente;
import com.example.baking_exercice.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteService(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
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
        clienteRepositoryPort.deletarPorId(id);
    }

    public List<Cliente> listarClientesComLimiteTotalMaiorQue(Double limite) {
        return clienteRepositoryPort.findClientesComLimiteTotalMaiorQue(limite);
    }
}