package com.desafio.Desafio_PicPay.domain.entity;

import com.desafio.Desafio_PicPay.domain.dtos.AccountRequestDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;

import java.util.UUID;

public class User {

    private UUID uuid;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Account account;

    public User(UserRequestDTO requestDTO) {
        this.name = requestDTO.name();
        this.cpf = requestDTO.cpf();
        this.email = requestDTO.email();
        this.password = requestDTO.password();
    }

    public User(){

    }

    public UUID getUuid(){
        return this.uuid;
    }

    public void setAccount(AccountRequestDTO accountDTO){
        this.account = new Account(accountDTO);
    }

    public Account getAccount(){
        return this.account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
