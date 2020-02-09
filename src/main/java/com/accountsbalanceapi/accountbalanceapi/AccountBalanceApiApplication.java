package com.accountsbalanceapi.accountbalanceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountBalanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountBalanceApiApplication.class, args);
	}

}
