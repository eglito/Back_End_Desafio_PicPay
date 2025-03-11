package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.AccountEntity;
import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.dtos.AccountDTO;
import com.desafio.Desafio_PicPay.domain.entity.Account;
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

        UserEntity userEntity = userRepository.findById(id).get();
        AccountEntity accountEntity = userEntity.getAccount();

        return accountEntity;
    }


    public ResponseEntity<AccountDTO> returnAccount(UUID id){

        AccountEntity account = getAccount(id);

        AccountDTO accountDTO = new AccountDTO(
                account.getValue(),
                account.getPayer(),
                account.getPayee());

        return ResponseEntity.ok(accountDTO);
    }

    public  ResponseEntity putAccount(UUID id, AccountDTO accountDTO){

        AccountEntity accountEntity = getAccount(id);

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


        return ResponseEntity.ok().build();

    }

}
