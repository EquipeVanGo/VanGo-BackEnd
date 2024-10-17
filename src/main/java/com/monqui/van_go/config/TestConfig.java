package com.monqui.van_go.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.monqui.van_go.entities.User;
import com.monqui.van_go.entities.location.Address;
import com.monqui.van_go.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Address address1 = new Address(null, "Sorocaba", "São Paulo", "123", "Rua Érick", "Apartamento 2", "Jardim das Maças");
		
		User user1 = new User(null, "20", "Érick", "ericknp15@gmail.com", "12345678", "15 999999997", address1);

		
		userRepository.saveAll(Arrays.asList(user1));
	}

}
