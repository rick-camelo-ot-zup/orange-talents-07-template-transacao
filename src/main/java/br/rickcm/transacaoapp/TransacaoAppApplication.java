package br.rickcm.transacaoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories(enableDefaultTransactions = false)
public class TransacaoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacaoAppApplication.class, args);
	}

}
