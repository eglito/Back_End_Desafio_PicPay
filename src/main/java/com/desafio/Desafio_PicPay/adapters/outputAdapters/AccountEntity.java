package com.desafio.Desafio_PicPay.adapters.outputAdapters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table(name = "accounts")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class AccountEntity {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private Double balance;

    public AccountEntity(){
    this.balance = 0.0;
    }
}
