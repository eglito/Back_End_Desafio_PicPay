package com.desafio.Desafio_PicPay.domain.dtos;

import java.util.UUID;

public record TransferDTO(
        Double value,
        UUID payer,
        UUID payee) {
}