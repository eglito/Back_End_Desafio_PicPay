package com.desafio.Desafio_PicPay.repositorios;

import com.desafio.Desafio_PicPay.adapters.outputAdapters.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
