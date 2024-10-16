package com.monqui.van_go.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monqui.van_go.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
