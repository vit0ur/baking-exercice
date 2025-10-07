package com.example.baking_exercice.interfaces.controllers;

import com.example.baking_exercice.application.services.CartaoCreditoService;
import com.example.baking_exercice.domain.CartaoCredito;
import com.example.baking_exercice.interfaces.dtos.CartaoCreditoRequestDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<CartaoCredito> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(cartaoCreditoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CartaoCredito> cadastrarCartaoCredito(@RequestBody CartaoCreditoRequestDTO cartaoCreditoRequestDTO){
        var cartaoCredito = new CartaoCredito();
        BeanUtils.copyProperties(cartaoCreditoRequestDTO, cartaoCredito);
        return ResponseEntity.ok(cartaoCreditoService.cadastrarCartaoCredito(cartaoCredito));
    }

    @PutMapping
    public ResponseEntity<CartaoCredito> atualizarCartaoCredito(@RequestBody CartaoCreditoRequestDTO cartaoCreditoRequestDTO){
        var cartaoCredito = new CartaoCredito();
        BeanUtils.copyProperties(cartaoCreditoRequestDTO, cartaoCredito);
        return ResponseEntity.ok(cartaoCreditoService.atualizarCartaoCredito(cartaoCredito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartaoCredito> deletarCartaoCredito(@PathVariable Long id){
        cartaoCreditoService.deletarCartaoCredito(id);
        return ResponseEntity.noContent().build();
    }
}