package com.monqui.van_go.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.monqui.van_go.dto.Trip.*;
import com.monqui.van_go.dto.Trip.TripByPassengerDTO;
import com.monqui.van_go.dto.passenger.PassengerRequestTripsDTO;
import com.monqui.van_go.entities.Enterprise;
import com.monqui.van_go.entities.Passenger;
import com.monqui.van_go.entities.TripPassenger;
import com.monqui.van_go.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.monqui.van_go.dto.driver.DriverRequestDTO;
import com.monqui.van_go.dto.passenger.PassengerRequestCreateDTO;
import com.monqui.van_go.dto.vehicle.VehicleRequestDTO;
import com.monqui.van_go.entities.Trips;
import com.monqui.van_go.entities.location.Address;
import com.monqui.van_go.services.interfaces.TripInterface;

@Service
public class TripService implements TripInterface {

	private final AddressRepository addressRepository;
	private final EnterpriseRepository enterpriseRepository;
	private final TripsRepository tripsRepository;
	private final PassengerRepository passengerRepository;

	public TripService(AddressRepository addressRepository, EnterpriseRepository enterpriseRepository, TripsRepository tripsRepository, PassengerRepository passengerRepository) {
		this.addressRepository = addressRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.tripsRepository = tripsRepository;
		this.passengerRepository = passengerRepository;
	}

	@Override
	public List<TripResponseFindAddressesDTO> findAddresses(TripRequestDTO tripRequestDTO) {
		Optional<Passenger> passenger = passengerRepository.findById(tripRequestDTO.getIdPassenger());
		List<Trips> tripsList = new ArrayList<>();

		if (tripRequestDTO.getDepartureLocation().isBlank()) {
			passenger.ifPresent(p -> {
				Address userAddress = p.getAddress();

				Trips mockTrip = new Trips();
				mockTrip.setDepartureLocation(
						userAddress.getAddress() + ", " +
								userAddress.getNumber() + " - " +
								userAddress.getNeighborhood() + ", " +
								userAddress.getCity() + " - " +
								userAddress.getState()
				);
				mockTrip.setArrivalLocation("Casa");
				mockTrip.setDepartureTime(LocalDateTime.now());
				mockTrip.setArrivalTime(LocalDateTime.now().plusMinutes(10));
				mockTrip.setDepartureLabel("Casa");

				tripsList.add(mockTrip);
			});
		} else {
			List<String> matchedTexts = tripsRepository.searchUniqueMatchingTexts(tripRequestDTO.getDepartureLocation());

			for (String text : matchedTexts) {
				Trips mockTrip = new Trips();
				mockTrip.setDepartureLocation(text);
				mockTrip.setDepartureLabel(text);
				tripsList.add(mockTrip);
			}
		}

		return tripsList.stream()
				.map(TripResponseFindAddressesDTO::new)
				.collect(Collectors.toList());
	}


	public Trips tripsCreate(TripRequestCreateDTO tripRequestCreateDTO) {

		Enterprise enterprise = enterpriseRepository.findById(tripRequestCreateDTO.getEnterpriseId())
				.orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

		Trips trips = new Trips(tripRequestCreateDTO.getTripId(),enterprise,
				tripRequestCreateDTO.getDriver(), tripRequestCreateDTO.getVehicle(),
				tripRequestCreateDTO.getDepartureTime(), tripRequestCreateDTO.getDepartureLocation(),
				tripRequestCreateDTO.getDepartureLabel(),tripRequestCreateDTO.getArrivalTime(),
				tripRequestCreateDTO.getArrivalLocation(),tripRequestCreateDTO.getArrivalLabel(),
				tripRequestCreateDTO.getPngRoute(), new ArrayList<>());

		return tripsRepository.save(trips);
	}

	@Override
	@Transactional
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
			dto.setDepartureLabel(trip.getDepartureLabel());
			dto.setArrivalLabel(trip.getArrivalLabel());

			List<PassengerRequestCreateDTO> passengerDTOs = trip.getTripPassengers().stream()
					.map(passenger -> new PassengerRequestCreateDTO(passenger.getId(), passenger.getPassenger().getName()))
					.collect(Collectors.toList());
			dto.setPassengers(passengerDTOs);

			return dto;
		}).collect(Collectors.toList());
	}

	@Transactional
	public Boolean insertPassengerOnTrip(PassengerRequestTripsDTO dadosPassageiro) {
		Optional<Trips> tripOptional = tripsRepository.findByTripId(dadosPassageiro.getTripId());
		Optional<Passenger> passengerOptional = passengerRepository.findById(dadosPassageiro.getPassengerId());

		if (tripOptional.isPresent() && passengerOptional.isPresent()) {
			Trips trip = tripOptional.get();
			Passenger passenger = passengerOptional.get();

			if (trip.getTripPassengers() == null) {
				trip.setTripPassengers(new ArrayList<>());
			}

			TripPassenger tripPassenger = new TripPassenger(trip, passenger,
					dadosPassageiro.getDepartureLabel(),
					dadosPassageiro.getArrivalLabel());

			trip.getTripPassengers().add(tripPassenger);

			tripsRepository.save(trip);
			return true;
		}
		return false;
	}

	public List<TripByDriverDTO> getTripsByDriverId(Long driverId) {
		List<Trips> trips = tripsRepository.findByDriverId_Id(driverId);

		return trips.stream().map(trip -> {
			TripByDriverDTO dto = new TripByDriverDTO();
			dto.setTripId(trip.getTripId());
			dto.setEnterpriseId(trip.getEnterpriseId() != null ? trip.getEnterpriseId().getId() : null);
			dto.setDriverId(trip.getDriverId() != null ? trip.getDriverId().getId() : null);
			dto.setDepartureTime(trip.getDepartureTime());
			dto.setArrivalTime(trip.getArrivalTime());

			List<TripByDriverDTO.PassengerSimpleDTO> passengerDTOs = trip.getTripPassengers().stream()
					.map(tp -> new TripByDriverDTO.PassengerSimpleDTO(
							tp.getPassenger().getId(),
							tp.getPassenger().getName(),
							tp.getDepartureLabel(),
							tp.getArrivalLabel()
					))
					.collect(Collectors.toList());

			dto.setPassengers(passengerDTOs);

			return dto;
		}).collect(Collectors.toList());
	}

	@Transactional
	public List<TripByPassengerDTO> getTripsByPassengerId(Long passengerId) {
		List<Trips> trips = tripsRepository.findTripsByPassengerId(passengerId);

		return trips.stream().map(trip -> {
			TripByPassengerDTO dto = new TripByPassengerDTO();
			dto.setTripId(trip.getTripId());
			dto.setDepartureTime(trip.getDepartureTime());
			dto.setArrivalTime(trip.getArrivalTime());
			dto.setDepartureLocation(trip.getDepartureLocation());
			dto.setArrivalLocation(trip.getArrivalLocation());

			dto.setDriverName(trip.getDriverId() != null ? trip.getDriverId().getName() : null);
			dto.setVehiclePlate(trip.getVehicleId() != null ? trip.getVehicleId().getPlate() : null);

			return dto;
		}).collect(Collectors.toList());
	}


}
