package com.desafio.Desafio_PicPay.domain.dtos;

public record UserRequestDTO(
        String name,
        String cpf,
        String email,
        String password) {
}
