package com.monqui.van_go.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monqui.van_go.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);

}
