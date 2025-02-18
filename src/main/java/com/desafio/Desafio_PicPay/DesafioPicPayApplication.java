package com.desafio.Desafio_PicPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.desafio.Desafio_PicPay.domain.entity",
		"com.desafio.Desafio_PicPay.adapters.outputAdapters"
})
public class DesafioPicPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPicPayApplication.class, args);
	}

}
