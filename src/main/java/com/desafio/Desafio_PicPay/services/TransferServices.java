package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.AccountEntity;
import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.TypeAccount;
import com.desafio.Desafio_PicPay.domain.dtos.TransferDTO;
import com.desafio.Desafio_PicPay.repositorios.AccountRepository;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransferServices {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private CheckStatusService checkStatusService;

    public TransferServices(AccountRepository accountRepository, UserRepository userRepository, CheckStatusService checkStatusService){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.checkStatusService = checkStatusService;
    }

    public ResponseEntity<Void> trasferAccount (TransferDTO transferDTO){

        boolean checkTest = this.checkStatusService.checkTransferForStatus(transferDTO.payer(), transferDTO.payee());

        if(!checkTest){
            throw new IllegalArgumentException("CORPORATE não podem transferir para PERSONAL");
        }

        UserEntity sender = userRepository.findById(transferDTO.payer()).get();
        AccountEntity accountTransmitter = sender.getAccount();
        UserEntity receiver = userRepository.findById(transferDTO.payee()).get();
        AccountEntity accountReceiver = receiver.getAccount();

        if(accountTransmitter.getBalance() >= transferDTO.value()){
            accountTransmitter.setBalance(accountTransmitter.getBalance() - transferDTO.value());
            accountReceiver.setBalance(accountReceiver.getBalance() + transferDTO.value());
        } else {
            throw new IllegalArgumentException("Saldo de transmitter é insuficiente");
        }

        accountRepository.save(accountTransmitter);
        accountRepository.save(accountReceiver);

        return ResponseEntity.ok().build();
    }


}

