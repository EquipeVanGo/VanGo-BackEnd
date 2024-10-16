package com.monqui.van_go.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monqui.van_go.entities.User;
import com.monqui.van_go.entities.location.Address;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		
		Address address = new Address(1L, "Sorocaba", "São Paulo", "123", "Rua Érick");
		User user = new User(1L, "20", "Érick", "ericknp15@gmail.com", "12345678", "15 999999999", address);
		
		return ResponseEntity.ok().body(user);
	}

}
