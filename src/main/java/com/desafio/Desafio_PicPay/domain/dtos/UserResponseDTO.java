package com.desafio.Desafio_PicPay.domain.dtos;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.AccountEntity;
import com.desafio.Desafio_PicPay.domain.entity.Account;

public record UserResponseDTO(
        String name,
        String email,
        String cpf
) {
}
