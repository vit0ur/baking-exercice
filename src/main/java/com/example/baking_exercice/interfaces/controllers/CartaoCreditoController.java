package com.example.baking_exercice.interfaces.controllers;

import com.example.baking_exercice.application.services.CartaoCreditoService;
import com.example.baking_exercice.domain.CartaoCredito;
import com.example.baking_exercice.interfaces.dtos.CartaoCreditoRequestDTO;
import com.example.baking_exercice.interfaces.dtos.CartaoCreditoResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.baking_exercice.application.services.CartaoCreditoService.toResponseDTO;

@RestController
@RequestMapping("/cartaoCredito")
public class CartaoCreditoController {
    private final CartaoCreditoService cartaoCreditoService;

    public CartaoCreditoController(CartaoCreditoService cartaoCreditoService) {
        this.cartaoCreditoService = cartaoCreditoService;
    }

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> listar(){
        return ResponseEntity.ok(cartaoCreditoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaoCreditoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(toResponseDTO(cartaoCreditoService.buscarPorId(id)));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<CartaoCredito>> listarPorCliente(@PathVariable Long idCliente) {
        List<CartaoCredito> cartoes = cartaoCreditoService.listarPorCliente(idCliente);
        return ResponseEntity.ok(cartoes);
    }

    @PostMapping
    public ResponseEntity<CartaoCreditoResponseDTO> cadastrarCartaoCredito(@RequestBody CartaoCreditoRequestDTO cartaoCreditoRequestDTO){
        var cartaoCredito = new CartaoCredito();
        BeanUtils.copyProperties(cartaoCreditoRequestDTO, cartaoCredito);
        return ResponseEntity.ok(toResponseDTO(cartaoCreditoService.cadastrarCartaoCredito(cartaoCredito)));
    }

    @PutMapping
    public ResponseEntity<CartaoCreditoResponseDTO> atualizarCartaoCredito(@RequestBody CartaoCreditoRequestDTO cartaoCreditoRequestDTO){
        var cartaoCredito = new CartaoCredito();
        BeanUtils.copyProperties(cartaoCreditoRequestDTO, cartaoCredito);
        return ResponseEntity.ok(toResponseDTO(cartaoCreditoService.atualizarCartaoCredito(cartaoCredito)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartaoCreditoResponseDTO> deletarCartaoCredito(@PathVariable Long id){
        cartaoCreditoService.deletarCartaoCredito(id);
        return ResponseEntity.noContent().build();
    }
}