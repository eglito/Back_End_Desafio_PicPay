package com.desafio.Desafio_PicPay.adapters.inputAdapters;

import com.desafio.Desafio_PicPay.domain.dtos.TransferDTO;
import com.desafio.Desafio_PicPay.services.TransferServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferServices services;

    @PutMapping
    public ResponseEntity transfer(@RequestBody TransferDTO transferDTO){
        return services.trasferAccount(transferDTO);
    }
}
