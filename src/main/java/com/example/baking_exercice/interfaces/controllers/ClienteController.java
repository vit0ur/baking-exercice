package com.example.baking_exercice.interfaces.controllers;

import com.example.baking_exercice.application.services.ClienteService;
import com.example.baking_exercice.domain.Cliente;
import com.example.baking_exercice.interfaces.dtos.ClienteRequestDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequestDTO, cliente);
        return ResponseEntity.ok(clienteService.cadastrarCliente(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequestDTO, cliente);
        return ResponseEntity.ok(clienteService.atualizarCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}