package com.desafio.Desafio_PicPay.domain.dtos;

import com.desafio.Desafio_PicPay.domain.TypeAccount;

public record UserRequestDTO(
        String name,
        String cpf,
        String email,
        TypeAccount status,
        String password) {
}
