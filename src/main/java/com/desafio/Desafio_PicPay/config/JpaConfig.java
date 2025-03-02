package com.desafio.Desafio_PicPay.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@ComponentScan(basePackages = {
        "com.desafio.Desafio_PicPay.services",
        "com.desafio.Desafio_PicPay.adapters.inputAdapters",
        "com.desafio.Desafio_PicPay.adapters.outputAdapters",
        "com.desafio.Desafio_PicPay.repositories"
})
@EnableJpaRepositories(basePackages = "com.desafio.Desafio_PicPay.repositorios")
@EntityScan("com.desafio.Desafio_PicPay.adapters.outputAdapters")
public class JpaConfig {

}