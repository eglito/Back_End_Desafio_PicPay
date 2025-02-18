package com.desafio.Desafio_PicPay.domain.dtos;

public record AccountRequestDTO(
        Double value,
        Double payer,
        Double payee) {
}
