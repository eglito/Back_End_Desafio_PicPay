package com.desafio.Desafio_PicPay.domain.entity;

import com.desafio.Desafio_PicPay.domain.dtos.AccountDTO;

import java.util.UUID;

public class Account {

    private Double value;
    private Double payer;
    private Double payee;
    private UUID uuid;

    public Account(AccountDTO accountDTO) {
        this.value = accountDTO.balance();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
