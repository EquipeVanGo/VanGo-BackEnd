package com.monqui.van_go.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.monqui.van_go.entities.Passenger;
import com.monqui.van_go.repositories.PassengerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.monqui.van_go.dto.Trip.TripRequestCreateDTO;
import com.monqui.van_go.dto.Trip.TripRequestDTO;
import com.monqui.van_go.dto.Trip.TripResponseAddressDTO;
import com.monqui.van_go.dto.Trip.TripResponseGenericDTO;
import com.monqui.van_go.dto.address.AddressRequestDTO;
import com.monqui.van_go.dto.driver.DriverRequestDTO;
import com.monqui.van_go.dto.passenger.PassengerRequestCreateDTO;
import com.monqui.van_go.dto.vehicle.VehicleRequestDTO;
import com.monqui.van_go.entities.Trips;
import com.monqui.van_go.entities.location.Address;
import com.monqui.van_go.repositories.AddressRepository;
import com.monqui.van_go.repositories.TripsRepository;
import com.monqui.van_go.services.interfaces.TripInterface;

@Service
public class TripService implements TripInterface {

	private final AddressRepository addressRepository;
	private final TripsRepository tripsRepository;
	private final PassengerRepository passengerRepository;

	public TripService(AddressRepository addressRepository, TripsRepository tripsRepository, PassengerRepository passengerRepository) {
		this.addressRepository = addressRepository;
		this.tripsRepository = tripsRepository;
		this.passengerRepository = passengerRepository;
	}

	@Override
	public List<Address> findAddresses(TripRequestDTO tripRequestDTO) {
		Optional<Passenger> passenger = passengerRepository.findById(tripRequestDTO.getIdPassenger());
		Long addresId = passenger.get().getAddress().getId();
		Optional<Address> userAddress = addressRepository.findById(addresId);
		Pageable limit = PageRequest.of(0, 10);

		List<Address> tripsAddresses = tripsRepository.searchTripsByText(tripRequestDTO.getDepartureLocation());
		for (Address address : tripsAddresses) {
			System.out.println(address);
		}
		List<Address> addressList = new ArrayList<>();
		if (tripRequestDTO.getDepartureLocation().isBlank()) {
			userAddress.ifPresent(addressList::add);
		}
		addressList.addAll(tripsAddresses);

		return addressList;

	}

	public Trips insert(TripRequestCreateDTO tripRequestCreateDTO) {
		Trips trips = new Trips(tripRequestCreateDTO.getTripId(), tripRequestCreateDTO.getEnterpriseId(),
				tripRequestCreateDTO.getDriver(), tripRequestCreateDTO.getVehicle(),
				tripRequestCreateDTO.getDepartureTime(), tripRequestCreateDTO.getDepartureLocation(),
				tripRequestCreateDTO.getDepartureLabel(),tripRequestCreateDTO.getArrivalTime(),
				tripRequestCreateDTO.getArrivalLocation(),tripRequestCreateDTO.getArrivalLabel(),
				tripRequestCreateDTO.getPngRoute(), new ArrayList<>(), new ArrayList<>());
		return tripsRepository.save(trips);
	}

	@Override
	public List<TripResponseGenericDTO> findTrips(TripRequestDTO tripRequestDTO) {
		List<Trips> trips = tripsRepository.findTripsByDepartureOrDestination(tripRequestDTO.getDepartureLocation(),
				tripRequestDTO.getArrivalLocation());

		return trips.stream().map(trip -> {
			TripResponseGenericDTO dto = new TripResponseGenericDTO();
			dto.setTripId(trip.getTripId());
			dto.setEnterpriseId(trip.getEnterpriseId() != null ? trip.getEnterpriseId().getId() : null);
			dto.setPngRoute(trip.getPngRoute());

			DriverRequestDTO driverDto = new DriverRequestDTO(trip.getDriverId().getId(), trip.getDriverId().getName(),
					trip.getDriverId().getCnh(), trip.getDriverId().getEmail());
			dto.setDriver(driverDto);

			VehicleRequestDTO vehicleDto = new VehicleRequestDTO(trip.getVehicleId().getId(),
					trip.getVehicleId().getModel(), trip.getVehicleId().getPlate(), trip.getVehicleId().getQuantityPlaces());
			dto.setVehicle(vehicleDto);

			dto.setAvailableSeats(trip.getVehicleId().getQuantityPlaces());
			dto.setDestination(trip.getArrivalLocation());
			dto.setDepartureTime(trip.getDepartureTime());
			dto.setDepartureLocation(trip.getDepartureLocation());
			dto.setEstimatedArrivalTime(trip.getArrivalTime());
			dto.setDepartureLabel("Departure");
			dto.setArrivalLabel("Arrival");

			List<PassengerRequestCreateDTO> passengerDTOs = trip.getPassengers().stream()
					.map(passenger -> new PassengerRequestCreateDTO(passenger.getId(), passenger.getName()))
					.collect(Collectors.toList());
			dto.setPassengers(passengerDTOs);

			List<AddressRequestDTO> addressDTOs = trip.getAddresses().stream()
					.map(address -> new AddressRequestDTO(address.getId(), address.getAddress(), address.getNumber(),
							address.getNeighborhood()))
					.collect(Collectors.toList());
			dto.setAddresses(addressDTOs);

			return dto;
		}).collect(Collectors.toList());
	}
}
