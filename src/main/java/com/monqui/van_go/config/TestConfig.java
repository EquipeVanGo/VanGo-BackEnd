package com.monqui.van_go.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.monqui.van_go.entities.Driver;
import com.monqui.van_go.entities.Passenger;
import com.monqui.van_go.entities.Timeline;
import com.monqui.van_go.entities.location.Address;
import com.monqui.van_go.repositories.DriverRepository;
import com.monqui.van_go.repositories.PassengerRepository;



@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
//	@Autowired
//	private VehicleRepository vehicleRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Timeline timeline1 = new Timeline(null, false, false, false, true, true, true, false);
		
		//Vehicle vehicle1 = new Vehicle(null, "448EAX", "Yellow", 2012, 19);
		
		Address address1 = new Address(null, "Sorocaba", "São Paulo", "123", "Rua Érick", "Apartamento 2", "Jardim das Maças");
		
		Address address2 = new Address(null, "Votorantim", "São Paulo", "456", "Rua Marlene", "Apartamento 25", "Jardim Nova Votorantim");

		
		Driver driver1 = new Driver(null, "20", "Érick", "ericknp15@gmail.com", "12345678", "15 999999997", address1,"cnh1", "AB", LocalDate.of(2024, 10, 18));

		Passenger passenger1 = new Passenger(null, "24", "Fábio", "fabiogamer@gmail.com", "8523149", "15 999999997", address2, timeline1);
		
		driverRepository.saveAll(Arrays.asList(driver1));
		passengerRepository.saveAll(Arrays.asList(passenger1));
		//vehicleRepository.saveAll(Arrays.asList(vehicle1));

	}

}
