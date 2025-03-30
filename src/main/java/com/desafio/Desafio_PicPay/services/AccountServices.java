package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.AccountEntity;
import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.dtos.AccountDTO;
import com.desafio.Desafio_PicPay.repositorios.AccountRepository;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServices {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccountServices(AccountRepository accountRepository, UserRepository userRepository){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    private AccountEntity getAccountId(UUID id){

        UserEntity userEntity = userRepository.findById(id).get();
        AccountEntity accountEntity = userEntity.getAccount();

        return accountEntity;
    }


    public ResponseEntity<AccountDTO> returnAccount(UUID id){

        AccountEntity account = getAccountId(id);
        AccountDTO accountDTO = new AccountDTO(
                account.getBalance());
        return ResponseEntity.ok(accountDTO);
    }

    public  ResponseEntity putAccount(UUID id, AccountDTO accountDTO){

        AccountEntity accountEntity = getAccountId(id);
        accountEntity.setBalance(accountDTO.balance());
        accountRepository.save(accountEntity);

        return ResponseEntity.ok().build();
    }

}
