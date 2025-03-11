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
    private final UserRepository userRepository;

    public TransferServices(AccountRepository accountRepository, UserRepository userRepository){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    //Verificação do status de contas
    public boolean checkTransferForStatus(UUID iDTransmitter, UUID iDReceiver){

        UserEntity userEntityTransmitter = userRepository.findById(iDTransmitter).get();
        UserEntity userEntityReceiver = userRepository.findById(iDReceiver).get();

        if(userEntityTransmitter.getStatus().equals(TypeAccount.CORPORATE) &&
            userEntityReceiver.getStatus().equals(TypeAccount.PERSONAL)){
            return false;
        }
        return true;
    }

    public ResponseEntity<Void> trasferAccount (TransferDTO transferDTO){

        if(!checkTransferForStatus(transferDTO.payer(), transferDTO.payee())){
            throw new IllegalArgumentException("CORPORATE não podem transferir para PERSONAL");
        }

        UserEntity userEntityTransmitter = userRepository.findById(transferDTO.payer()).get();
        AccountEntity accountTransmitter = userEntityTransmitter.getAccount();
        UserEntity userEntityReceiver = userRepository.findById(transferDTO.payee()).get();
        AccountEntity accountReceiver = userEntityReceiver.getAccount();

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

