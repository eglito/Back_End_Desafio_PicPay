package com.desafio.Desafio_PicPay.repositorios;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
