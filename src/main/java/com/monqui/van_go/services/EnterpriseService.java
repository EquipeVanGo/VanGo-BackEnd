package com.monqui.van_go.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monqui.van_go.entities.Enterprise;
import com.monqui.van_go.repositories.EnterpriseRepository;

@Service
public class EnterpriseService {
	
	@Autowired
	private EnterpriseRepository repository;
	
	public List<Enterprise> findAll(){
		return repository.findAll();
	}
	
	public Enterprise findById(Long id) {
		
		Optional<Enterprise> obj = repository.findById(id);
		return obj.get();
	}
	
	public Enterprise insert(Enterprise enterprise) {	
		return repository.save(enterprise);
	}
	
	public void delete(Long id) {	
		repository.deleteById(id);
	}
	
	public Enterprise update(Long id, Enterprise enterprise) {
		
		Enterprise entity = repository.getReferenceById(id);
		updateData(entity, enterprise);
		return repository.save(entity);
		
	}

	private void updateData(Enterprise entity, Enterprise enterprise) {
		//Padrão do User (Retirado Age)
		entity.setName(enterprise.getName());
		entity.setEmail(enterprise.getEmail());
		entity.setPassword(enterprise.getPassword());
		entity.setTelephone(enterprise.getTelephone());
		entity.setAddress(enterprise.getAddress());
		
		//Variáveis da empresa
		entity.setDrivers(enterprise.getDrivers());
		entity.setVehicles(enterprise.getVehicles());



		
		
	}

}
