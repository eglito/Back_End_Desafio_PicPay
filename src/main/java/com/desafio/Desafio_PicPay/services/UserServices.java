package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.AccountEntity;
import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserResponseDTO;
import com.desafio.Desafio_PicPay.repositorios.AccountRepository;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServices {

    @Autowired
    private UserRepository repository;
    private AccountRepository accountRepository;


    public void creatUser(UserRequestDTO userRequestDTODTO){
        UserEntity newUserEntity = new UserEntity(userRequestDTODTO);
        repository.save(newUserEntity);
    }

    public ResponseEntity<UserResponseDTO> getUser(Long id){

        UserEntity userEntity = (UserEntity) repository.findAllById(id).get();

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getCpf(),
                userEntity.getAccount());

        return ResponseEntity.ok(userResponseDTO);
    }

    public ResponseEntity updateUser(UserRequestDTO userRequestDTO, Long id){

        UserEntity userEntity = (UserEntity) repository.findAllById(id).get();
        if(userEntity.getName() != userRequestDTO.name()){
            userEntity.setName(userEntity.getName());
        }
        if(userEntity.getCpf() != userRequestDTO.cpf()){
            userEntity.setCpf(userRequestDTO.cpf());
        }
        if(userEntity.getEmail() != userRequestDTO.email()){
            userEntity.setCpf(userRequestDTO.cpf());
        }
        if(userEntity.getPassword() != userRequestDTO.password()){
            userEntity.setPassword(userRequestDTO.password());
        }

        return ResponseEntity.ok().build();
    }

    public ResponseEntity deleteUser(Long id){

        repository.findAllById(id).remove();
        return ResponseEntity.ok().build();

    }

}
