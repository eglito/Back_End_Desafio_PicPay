package com.desafio.Desafio_PicPay.repositorios;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.dtos.EmailResponseDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
/*
    UserRequestDTO creatUser();

    ResponseEntity getUser(UUID id);

    ResponseEntity upDateUser (UUID id);

    ResponseEntity deleteUser(UUID id);

    List<EmailResponseDTO> getAll();
*/
}
