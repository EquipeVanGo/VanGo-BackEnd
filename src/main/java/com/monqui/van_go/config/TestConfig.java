package com.monqui.van_go.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.monqui.van_go.entities.Driver;
import com.monqui.van_go.entities.Enterprise;
import com.monqui.van_go.entities.Passenger;
import com.monqui.van_go.entities.Timeline;
import com.monqui.van_go.entities.Vehicle;
import com.monqui.van_go.entities.location.Address;
import com.monqui.van_go.repositories.DriverRepository;
import com.monqui.van_go.repositories.EnterpriseRepository;
import com.monqui.van_go.repositories.PassengerRepository;



@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	    Address address3 = new Address(null, "São Paulo", "São Paulo", "456", "Liberdade", "Prédio amarelo", "Jardim Nova SP");
	    Enterprise enterprise1 = new Enterprise(null, "Van GO", "van_go@gmail.com", "789456123", null, address3, "5151651231", Arrays.asList(), Arrays.asList());
	    
	    Vehicle vehicle1 = new Vehicle(null, "448EAX", "Yellow", 2012, 19, enterprise1);
	    enterprise1.setVehicles(Arrays.asList(vehicle1));

	    Address address1 = new Address(null, "Sorocaba", "São Paulo", "123", "Rua Érick", "Apartamento 2", "Jardim das Maças");
	    Driver driver1 = new Driver(null, "20", "Érick", "ericknp15@gmail.com", "12345678", "15 999999997", address1, "cnh1", "AB", LocalDate.of(2024, 10, 18), enterprise1, null);
	    enterprise1.setDrivers(Arrays.asList(driver1));

	    enterpriseRepository.save(enterprise1);
	    driverRepository.save(driver1);

	    Address address2 = new Address(null, "Votorantim", "São Paulo", "456", "Rua Marlene", "Apartamento 25", "Jardim Nova Votorantim");
	    Timeline timeline1 = new Timeline(null, false, false, false, true, true, true, false);
	    Passenger passenger1 = new Passenger(null, "24", "Fábio", "fabiogamer@gmail.com", "8523149", "15 999999997", address2, timeline1);

	    passengerRepository.save(passenger1);
	}

}
