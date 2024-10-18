package com.monqui.van_go.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monqui.van_go.entities.Passenger;
import com.monqui.van_go.repositories.PassengerRepository;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository repository;
	
	public List<Passenger> findAll(){
		return repository.findAll();
	}
	
	public Passenger findById(Long id) {
		
		Optional<Passenger> obj = repository.findById(id);
		return obj.get();
	}
	
	public Passenger insert(Passenger passenger) {	
		return repository.save(passenger);
	}
	
	public void delete(Long id) {	
		repository.deleteById(id);
	}
	
	public Passenger update(Long id, Passenger passenger) {
		
		Passenger entity = repository.getReferenceById(id);
		updateData(entity, passenger);
		return repository.save(entity);
		
	}

	private void updateData(Passenger entity, Passenger passenger) {
		//Padrão do User
		entity.setName(passenger.getName());
		entity.setAge(passenger.getAge());
		entity.setEmail(passenger.getEmail());
		entity.setPassword(passenger.getPassword());
		entity.setTelephone(passenger.getTelephone());
		entity.setAddress(passenger.getAddress());
		
		//Variáveis do passageiro
		entity.setTimeline(passenger.getTimeline());

		
		
	}

}
