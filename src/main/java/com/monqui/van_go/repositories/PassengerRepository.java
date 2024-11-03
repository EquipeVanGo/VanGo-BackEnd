package com.monqui.van_go.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monqui.van_go.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

    List<Passenger> findByActiveTrue();

}
