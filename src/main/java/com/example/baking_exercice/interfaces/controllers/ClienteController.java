package com.example.baking_exercice.interfaces.controllers;

import com.example.baking_exercice.application.services.ClienteService;
import com.example.baking_exercice.domain.Cliente;
import com.example.baking_exercice.interfaces.dtos.ClienteRequestDTO;
import com.example.baking_exercice.interfaces.dtos.ClienteResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.example.baking_exercice.application.services.ClienteService.toResponseDTO;

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
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(toResponseDTO(clienteService.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequestDTO, cliente);
        return ResponseEntity.ok(toResponseDTO(clienteService.cadastrarCliente(cliente)));
    }

    @PutMapping
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequestDTO, cliente);
        return ResponseEntity.ok(toResponseDTO(clienteService.atualizarCliente(cliente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/limite-maior-que")
    public ResponseEntity<List<Cliente>> getClientesComLimiteMaiorQue(@RequestParam Double limite) {
        List<Cliente> clientes = clienteService.listarClientesComLimiteTotalMaiorQue(limite);
        return ResponseEntity.ok(clientes);
    }

}