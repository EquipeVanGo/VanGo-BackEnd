package com.monqui.van_go.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monqui.van_go.entities.Driver;
import com.monqui.van_go.repositories.DriverRepository;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository repository;
	
	public List<Driver> findAll(){
		return repository.findAll();
	}
	
	public Driver findById(Long id) {
		
		Optional<Driver> obj = repository.findById(id);
		return obj.get();
	}
	
	public Driver insert(Driver driver) {	
		return repository.save(driver);
	}

}
