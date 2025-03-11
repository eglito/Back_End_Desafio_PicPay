package com.desafio.Desafio_PicPay.adapters.inputAdapters;

import com.desafio.Desafio_PicPay.domain.dtos.AccountDTO;
import com.desafio.Desafio_PicPay.services.AccountServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServices services;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable UUID id){
        return ResponseEntity.ok(services.returnAccount(id).getBody());
    }

    //Inserir valor em account
    @PutMapping("/update/{id}")
    public ResponseEntity updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable UUID id){
        return ResponseEntity.ok(services.putAccount(id, accountDTO).getBody());
    }

}
