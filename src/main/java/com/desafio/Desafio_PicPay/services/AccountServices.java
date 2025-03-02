package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.AccountEntity;
import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.dtos.AccountDTO;
import com.desafio.Desafio_PicPay.domain.dtos.EmailResponseDTO;
import com.desafio.Desafio_PicPay.repositorios.AccountRepository;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServices {

    public final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccountServices(AccountRepository accountRepository, UserRepository userRepository){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public AccountEntity getAccount(UUID id){
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException(""));
        return accountEntity;
    }


    public ResponseEntity<AccountDTO> returnAccount(UUID id){

        AccountEntity accountEntity = this.getAccount(id);
        AccountDTO accountDTO = new AccountDTO(
                accountEntity.getValue(),
                accountEntity.getPayer(),
                accountEntity.getPayee());

        return ResponseEntity.ok(accountDTO);
    }

    public  ResponseEntity putAccount(UUID id, AccountDTO accountDTO){

        AccountEntity accountEntity = this.getAccount(id);
        //UserEntity userEntity = userRepository.getById(id);

        if(accountEntity.getValue() != accountDTO.value()){
            accountEntity.setValue(accountDTO.value());
        }
        if(accountEntity.getPayer() != accountDTO.payer()){
            accountEntity.setPayer(accountDTO.payer());
        }
        if(accountEntity.getPayee() != accountDTO.payee()){
            accountEntity.setPayee(accountDTO.payee());
        }

        accountRepository.save(accountEntity);

        //EmailResponseDTO email = new EmailResponseDTO(userEntity.getEmail());

        return ResponseEntity.ok().build();

    }

}

