package com.desafio.Desafio_PicPay.domain.entity;

import com.desafio.Desafio_PicPay.domain.dtos.AccountRequestDTO;

import java.util.UUID;

public class Account {

    private Double value;
    private Double payer;
    private Double payee;
    private UUID uuid;

    public Account(AccountRequestDTO accountDTO) {
        this.value = accountDTO.value();
        this.payer = accountDTO.payer();
        this.payee = accountDTO.payee();
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

    public Double getPayer() {
        return payer;
    }

    public void setPayer(Double payer) {
        this.payer = payer;
    }

    public Double getPayee() {
        return payee;
    }

    public void setPayee(Double payee) {
        this.payee = payee;
    }
}
