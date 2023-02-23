package com.john.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.john.crudspring.model.Client;
import com.john.crudspring.repository.ClientRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ClientRepository clientRepository) {
		return args -> {
			clientRepository.deleteAll();

			Client c = new Client();
				c.setName("John Junior");
				c.setCpf("00012232298");
				c.setIdade("25");

				clientRepository.save(c);
			
		};				
	}
}
