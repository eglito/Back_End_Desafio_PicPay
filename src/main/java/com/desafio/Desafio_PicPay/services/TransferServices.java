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

        if(userEntityTransmitter.getStatus().equals(TypeAccount.CORPORATE) &&
            userEntityReceiver.getStatus().equals(TypeAccount.PERSONAL)){
            return true;
        }
        return false;
    }

    public ResponseEntity<Void> trasferAccount (UUID iDTransmitter, AccountDTO dtoTransmitter, UUID iDReceiver, AccountDTO dtoReceiver){

        if(checkTransferForStatus(iDTransmitter,iDReceiver)){
            throw new IllegalArgumentException("CORPORATE não podem tranferir para PERSONAL");
        }


        return ResponseEntity.ok().build();
    }


}
/*
    public ResposeEntity<> transer(iDTransmitter UUID, iDReceiver UUID){




        - Acessar o Repositório User e "pegar" o Id presente na coluna account
        - Inserir esse iD em uma variável
        - Usar essa variável para realizar a busca no repositório Account
        -
    }
 */
