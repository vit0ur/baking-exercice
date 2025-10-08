package com.example.baking_exercice.interfaces.dtos;

import com.example.baking_exercice.domain.CartaoCredito;
import java.util.List;

public record ClienteResponseDTO (String nome, String email,List<CartaoCredito> cartoes){
}