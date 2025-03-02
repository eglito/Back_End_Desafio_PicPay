package com.desafio.Desafio_PicPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.desafio.Desafio_PicPay.repositorios.UserRepository")
//@EntityScan("com.desafio.Desafio_PicPay.adapters.outputAdapters")
public class DesafioPicPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPicPayApplication.class, args);
	}

}
