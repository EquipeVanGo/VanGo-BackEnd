package com.monqui.van_go.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monqui.van_go.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
