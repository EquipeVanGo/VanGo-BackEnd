package com.monqui.van_go.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.monqui.van_go.entities.Driver;
import com.monqui.van_go.services.DriverService;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {
	
	@Autowired
	private DriverService service;
	
	
	@GetMapping
	public ResponseEntity<List<Driver>> findAll() {
		
		List<Driver> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Driver> findById(@PathVariable Long id){
		Driver driver = service.findById(id);
		return ResponseEntity.ok().body(driver);
	}
	
	@PostMapping
	public ResponseEntity<Driver> insert(@RequestBody Driver driver){
		driver = service.insert(driver);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(driver.getId()).toUri();
		return ResponseEntity.created(uri).body(driver);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}/activate")
	public ResponseEntity<Driver> activate(@PathVariable Long id) {
	    Driver driver = service.activate(id);
	    return ResponseEntity.ok().body(driver);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Driver> update(@PathVariable Long id, @RequestBody Driver driver){
		
		driver = service.update(id, driver);
		return ResponseEntity.ok().body(driver);
		
	}
	
	@PatchMapping("/{driverId}/{vehicleId}")
	public ResponseEntity<Driver> assignVehicleToDriver(@PathVariable Long driverId, @PathVariable Long vehicleId) {

		Driver driver = service.assignVehicleToDriver(driverId, vehicleId);
		return ResponseEntity.ok().body(driver);
	}
	
	
}
