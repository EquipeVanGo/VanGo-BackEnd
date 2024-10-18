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
	
	public void delete(Long id) {	
		repository.deleteById(id);
	}
	
	public Driver update(Long id, Driver driver) {
		
		Driver entity = repository.getReferenceById(id);
		updateData(entity, driver);
		return repository.save(entity);
		
	}

	private void updateData(Driver entity, Driver driver) {
		//Padrão do User
		entity.setName(driver.getName());
		entity.setAge(driver.getAge());
		entity.setEmail(driver.getEmail());
		entity.setPassword(driver.getPassword());
		entity.setTelephone(driver.getTelephone());
		entity.setAddress(driver.getAddress());
		
		//Variáveis do motorista
		entity.setCnh(driver.getCnh());
		entity.setCnhCategory(driver.getCnhCategory());
		entity.setValidityCnh(driver.getValidityCnh());	
		
	}

}
