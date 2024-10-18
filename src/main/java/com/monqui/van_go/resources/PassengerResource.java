package com.monqui.van_go.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.monqui.van_go.entities.Passenger;
import com.monqui.van_go.services.PassengerService;

@RestController
@RequestMapping(value = "/passengers")
public class PassengerResource {
	
	@Autowired
	private PassengerService service;
	
	@GetMapping
	public ResponseEntity<List<Passenger>> findAll() {
		
		List<Passenger> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Passenger> findById(@PathVariable Long id){
		Passenger passenger = service.findById(id);
		return ResponseEntity.ok().body(passenger);
	}
	
	@PostMapping
	public ResponseEntity<Passenger> insert(@RequestBody Passenger passenger){
		passenger = service.insert(passenger);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(passenger.getId()).toUri();
		return ResponseEntity.created(uri).body(passenger);
	}
	
	
//	Ainda não é preciso se preocupar com isso, porém, ao criar a classe "Viagem" 
//	será necessário modificar os métodos de delete por violar integridade do db.
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Passenger> update(@PathVariable Long id, @RequestBody Passenger passenger){
		
		passenger = service.update(id, passenger);
		return ResponseEntity.ok().body(passenger);
		
	}
	
	
	
	
	

}
