package com.monqui.van_go.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monqui.van_go.entities.Vehicle;
import com.monqui.van_go.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository repository;
	
	public List<Vehicle> findAll(){
		return repository.findAll();
	}
	
	public Vehicle findById(Long id) {
		
		Optional<Vehicle> obj = repository.findById(id);
		return obj.get();
	}
	
	public Vehicle insert(Vehicle vehicle) {	
		return repository.save(vehicle);
	}
	
	public void delete(Long id) {	
		repository.deleteById(id);
	}
	
	public Vehicle update(Long id, Vehicle vehicle) {
		
		Vehicle entity = repository.getReferenceById(id);
		updateData(entity, vehicle);
		return repository.save(entity);
		
	}

	private void updateData(Vehicle entity, Vehicle vehicle) {
		entity.setPlate(vehicle.getPlate());
		entity.setColor(vehicle.getColor());
		entity.setYear(vehicle.getYear());	
		entity.setQuantityPlaces(vehicle.getQuantityPlaces());
	}

}
