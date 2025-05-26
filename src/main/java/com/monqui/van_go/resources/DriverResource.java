package com.monqui.van_go.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<Driver> findById(@PathVariable Long id) {
		Driver driver = service.findById(id);
		return ResponseEntity.ok().body(driver);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}/activate")
	public ResponseEntity<Driver> activate(@PathVariable Long id) {
		Driver driver = service.activate(id);
		return ResponseEntity.ok().body(driver);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Driver> update(@PathVariable Long id, @RequestBody Driver driver) {

		driver = service.update(id, driver);
		return ResponseEntity.ok().body(driver);

	}

	@PatchMapping("/{driverId}/{vehicleId}")
	public ResponseEntity<Driver> assignVehicleToDriver(@PathVariable Long driverId, @PathVariable Long vehicleId) {

		Driver driver = service.assignVehicleToDriver(driverId, vehicleId);
		return ResponseEntity.ok().body(driver);
	}

	@PatchMapping("/{driverId}/removeVehicle")
	public ResponseEntity<Driver> assignVehicleToDriver(@PathVariable Long driverId) {

		Driver driver = service.removeVehicleFromDriver(driverId);
		return ResponseEntity.ok().body(driver);
	}

	@PostMapping("/validate")
	public ResponseEntity<Boolean> isValidDriver(@RequestBody Map<String, String> loginData) {
		String email = loginData.get("email");
		String password = loginData.get("password");

		Boolean isValid = service.isValidDriver(email, password);
		return ResponseEntity.ok(isValid);
	}

}
