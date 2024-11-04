package com.monqui.van_go.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.monqui.van_go.entities.Passenger;
import com.monqui.van_go.repositories.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository repository;

	public List<Passenger> findAll() {
		return repository.findByActiveTrue();
	}

	public Passenger findById(Long id) {

		Optional<Passenger> obj = repository.findById(id);
		return obj.get();
	}

	public Passenger insert(Passenger passenger) {
		return repository.save(passenger);
	}

	public void delete(Long id) {
		Passenger passenger = findById(id);
		if (passenger == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found with ID: " + id);
		}

		passenger.setActive(false);
		repository.save(passenger);
	}

	public Passenger activate(Long id) {
		Passenger passenger = findById(id);
		if (passenger == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found with ID: " + id);
		}

		passenger.setActive(true);
		return update(id, passenger);
	}

	public Passenger update(Long id, Passenger passenger) {

		Passenger entity = repository.getReferenceById(id);
		updateData(entity, passenger);
		return repository.save(entity);

	}

	private void updateData(Passenger entity, Passenger passenger) {
		// Padrão do User
		entity.setName(passenger.getName());
		entity.setAge(passenger.getAge());
		entity.setEmail(passenger.getEmail());
		entity.setPassword(passenger.getPassword());
		entity.setTelephone(passenger.getTelephone());
		entity.setAddress(passenger.getAddress());


		// Variáveis do passageiro
		entity.setTimeline(passenger.getTimeline());
		entity.setActive(passenger.getActive());

	}

}
