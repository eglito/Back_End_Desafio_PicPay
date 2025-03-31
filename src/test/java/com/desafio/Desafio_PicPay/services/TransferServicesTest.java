package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.TypeAccount;
import com.desafio.Desafio_PicPay.domain.dtos.TransferDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import com.desafio.Desafio_PicPay.repositorios.AccountRepository;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransferServicesTest {

    @Autowired
    @InjectMocks
    private AccountRepository accountRepository;

    @Mock
    private CheckStatusService checkStatusService;

    @Mock
    private TransferServices transferServices;

    @Autowired
    EntityManager entityManager;

    @Autowired
    @InjectMocks
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create transaction successfully when everything is OK")
    void trasferAccountCase1() {

        UserEntity sender= this.createUserEntity(new UserRequestDTO("Marina", "999.999.999-00", "marina@gmail.com", TypeAccount.PERSONAL, "@Araraquara016"));
        UserEntity receiver = this.createUserEntity(new UserRequestDTO("Juliene", "888.888.888-00", "juliene@gmail.com", TypeAccount.PERSONAL, "@Araraquara016"));

        when(checkStatusService.checkTransferForStatus(any(), any())).thenReturn(true);

        TransferDTO transferDTO = new TransferDTO(10.0, sender.getId (), receiver.getId ());
        this.transferServices.trasferAccount(transferDTO);


        verify(userRepository, times(1)).save(sender);
        verify(userRepository, times(1)).save(receiver);


    }

    @Test
    @DisplayName("Should when transaction is not allowed")
    void trasferAccountCase2() {

    }

    private UserEntity createUserEntity(UserRequestDTO userRequestDTO){
        UserEntity newUser = new UserEntity(userRequestDTO);
        this.entityManager.persist(newUser);
        return newUser;
    }
}