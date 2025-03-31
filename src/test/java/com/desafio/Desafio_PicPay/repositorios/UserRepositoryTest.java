package com.desafio.Desafio_PicPay.repositorios;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static com.desafio.Desafio_PicPay.domain.TypeAccount.PERSONAL;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")

class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should create and get user successfully from DB")
    void createAndGetUserCase1(){

        UserRequestDTO userRequestDTO = new UserRequestDTO("Alexandre","410.569.444-40", "alexandre@gmail.com", PERSONAL, "@Araraquara16");
        UserEntity userEntity = this.createUserEntity(userRequestDTO);

        Optional<UserEntity> result = this.userRepository.findById(userEntity.getId());

        assertThat(result.isPresent()).isTrue();
        assertThat(userEntity.getId()).isNotNull();
        assertThat(userRequestDTO.name()).isEqualTo(userEntity.getName());
    }

    @Test
    @DisplayName("Should update entity")
    void updateUserCase1(){

        UserRequestDTO userRequestDTO = new UserRequestDTO("Alexandre","410.569.444-40", "alexandre@gmail.com", PERSONAL, "@Araraquara16");
        UserEntity userEntity = this.createUserEntity(userRequestDTO);

        userEntity.setName("Luiz");
        this.userRepository.save(userEntity);

        UserEntity userEntityUpdate = this.userRepository.findById(userEntity.getId()).orElse(null);
        assertThat(userEntityUpdate).isNotNull();
        assertThat(userEntityUpdate.getName()).isEqualTo("Luiz");

    }


    private UserEntity createUserEntity(UserRequestDTO userRequestDTO){

        UserEntity newUser = new UserEntity(userRequestDTO);
        this.entityManager.persist(newUser);
        return newUser;
    }

}