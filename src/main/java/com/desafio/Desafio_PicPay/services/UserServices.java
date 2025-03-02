package com.desafio.Desafio_PicPay.services;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.dtos.EmailResponseDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserResponseDTO;
import com.desafio.Desafio_PicPay.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices {


    private final UserRepository repository;

    @Autowired
    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        UserEntity newUserEntity = new UserEntity(userRequestDTO);
        repository.save(newUserEntity);

        return new UserResponseDTO(
                newUserEntity.getName(),
                newUserEntity.getCpf(),
                newUserEntity.getEmail()
        );
    }

    public ResponseEntity<UserResponseDTO> getUser(UUID id){

        UserEntity userEntity =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getCpf());

        return ResponseEntity.ok(userResponseDTO);
    }

    public ResponseEntity updateUser(UserRequestDTO userRequestDTO, UUID id){

        UserEntity userEntity = repository.findById(id)
                                          .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


        if(!userEntity.getName().equals(userRequestDTO.name())){
            userEntity.setName(userRequestDTO.name());
        }
        if(!userEntity.getCpf().equals(userRequestDTO.cpf())){
            userEntity.setCpf(userRequestDTO.cpf());
        }
        if(!userEntity.getEmail().equals(userRequestDTO.email())){
            userEntity.setEmail(userRequestDTO.email());
        }
        if(!userEntity.getPassword().equals(userRequestDTO.password())){
            userEntity.setPassword(userRequestDTO.password());
        }

        repository.save(userEntity);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity deleteUser(UUID id){

        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public List<EmailResponseDTO> getAll(){

        List<UserEntity> users = repository.findAll();
        List<EmailResponseDTO> listEmails = users.stream()
                                    .map(email -> new EmailResponseDTO(email.getEmail()))
                                    .toList();
        return listEmails;
    }

}
