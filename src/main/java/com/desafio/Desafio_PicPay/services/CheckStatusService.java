package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.TypeAccount;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckStatusService {

    private UserRepository repository;

    public boolean checkTransferForStatus(UUID iDTransmitter, UUID iDReceiver){

        UserEntity sender = repository.findById(iDTransmitter).get();
        UserEntity receiver = repository.findById(iDReceiver).get();

        if(sender.getStatus().equals(TypeAccount.CORPORATE) &&
                receiver.getStatus().equals(TypeAccount.PERSONAL)){
            return false;
        }
        return true;
    }

}
