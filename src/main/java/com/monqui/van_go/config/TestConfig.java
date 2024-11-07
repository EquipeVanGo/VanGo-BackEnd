package com.monqui.van_go.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        Enterprise enterprise1 = new Enterprise(null, "Van GO", "van_go@gmail.com", "789456123", null, address3, "5151651231", new ArrayList<>(), new ArrayList<>());

        List<Vehicle> vehicles = new ArrayList<>();
        List<Driver> drivers = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Vehicle vehicle = new Vehicle(
                null,
                "PLATE" + i,
                "Color" + i,
                2000 + i, 
                15 + (i % 5), 
                enterprise1
            );
            vehicles.add(vehicle);

            Address driverAddress = new Address(
                null,
                "City" + i,
                "São Paulo",
                "Address" + i,
                "Street" + i,
                "AdditionalInfo" + i,
                "Neighborhood" + i
            );

            Driver driver = new Driver(
                null,
                String.valueOf(20 + i),
                "Driver" + i,
                "driver" + i + "@gmail.com",
                "password" + i,
                "15 999999" + String.format("%03d", i),
                driverAddress,
                "cnh" + i,
                "Category" + (i % 3 == 0 ? "AB" : "B"),
                LocalDate.now().plusYears(i), 
                enterprise1,
                null
            );
            drivers.add(driver);
        }

        enterprise1.setVehicles(vehicles);
        enterprise1.setDrivers(drivers);

        enterpriseRepository.save(enterprise1);
        for (Driver driver : drivers) {
            driverRepository.save(driver);
        }

	    Address address2 = new Address(null, "Votorantim", "São Paulo", "456", "Rua Marlene", "Apartamento 25", "Jardim Nova Votorantim");
	    Timeline timeline1 = new Timeline(null, false, false, false, true, true, true, false);
	    Passenger passenger1 = new Passenger(null, "24", "Fábio", "fabiogamer@gmail.com", "8523149", "15 999999997", address2, timeline1);

	    passengerRepository.save(passenger1);
	}

}
