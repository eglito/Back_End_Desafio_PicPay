package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.TypeAccount;
import com.desafio.Desafio_PicPay.domain.dtos.AccountDTO;
import com.desafio.Desafio_PicPay.repositorios.AccountRepository;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransferServices {

    @Autowired
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public TransferServices(UserRepository userRepository, AccountRepository accountRepository){
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public boolean checkTransferForStatus(UUID iDTransmitter, UUID iDReceiver){

        UserEntity userEntityTransmitter = userRepository.findById(iDTransmitter).get();
        UserEntity userEntityReceiver = userRepository.findById(iDReceiver).get();

        if(!userEntityTransmitter.getStatus().equals(TypeAccount.CORPORATE) &&
            userEntityReceiver.getStatus().equals(TypeAccount.PERSONAL)){
            return false;
        }
        return true;
    }

    public ResponseEntity<Void> trasferAccount (UUID iDTransmitter, AccountDTO dtoTransmitter, UUID iDReceiver, AccountDTO dtoReceiver){

        if(checkTransferForStatus(iDTransmitter,iDReceiver)){
            throw new IllegalArgumentException("CORPORATE não podem tranferir para PERSONAL");
        }


        return ResponseEntity.ok().build();
    }


}

