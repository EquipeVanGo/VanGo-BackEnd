package com.monqui.van_go.services;

import com.monqui.van_go.dto.Trip.TripRequestDTO;
import com.monqui.van_go.dto.Trip.TripResponseAddressDTO;
import com.monqui.van_go.dto.Trip.TripResponseGenericDTO;
import com.monqui.van_go.dto.address.AddressRequestDTO;
import com.monqui.van_go.dto.driver.DriverRequestDTO;
import com.monqui.van_go.dto.passenger.PassengerRequestCreateDTO;
import com.monqui.van_go.dto.vehicle.VehicleRequestDTO;
import com.monqui.van_go.entities.location.Address;
import com.monqui.van_go.entities.Trips;
import com.monqui.van_go.repositories.AddressRepository;
import com.monqui.van_go.repositories.TripsRepository;
import com.monqui.van_go.services.interfaces.TripInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService implements TripInterface {

    private final AddressRepository addressRepository;
    private final TripsRepository tripsRepository;

    public TripService(AddressRepository addressRepository, TripsRepository tripsRepository) {
        this.addressRepository = addressRepository;
        this.tripsRepository = tripsRepository;
    }

    @Override
    public List<TripResponseAddressDTO> findAddresses(TripRequestDTO tripRequestDTO) {
        List<Address> addresses = addressRepository.findByAddressContainingIgnoreCase(tripRequestDTO.getArrivalLocation());

        return addresses.stream()
                .map(address -> TripResponseAddressDTO.builder()
                        .streetAddress(address.getAddress())
                        .number(address.getNumber())
                        .complement(address.getComplement())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TripResponseGenericDTO> findTrips(TripRequestDTO tripRequestDTO) {
        List<Trips> trips = tripsRepository.findTripsByDepartureOrDestination(
                tripRequestDTO.getDepartureLocation(),
                tripRequestDTO.getArrivalLocation()
        );

        return trips.stream()
                .map(trip -> TripResponseGenericDTO.builder()
                        .tripId(trip.getTripId())
                        .enterpriseId(trip.getEnterpriseId() != null ? trip.getEnterpriseId().getId() : null)
                        .pngRoute(trip.getPngRoute())
                        .driver(new DriverRequestDTO(
                                trip.getDriver().getId(),
                                trip.getDriver().getName(),
                                trip.getDriver().getCnh(),
                                trip.getDriver().getEmail()
                        ))
                        .vehicle(new VehicleRequestDTO(
                                trip.getVehicle().getId(),
                                trip.getVehicle().getModel(),
                                trip.getVehicle().getPlate(),
                                trip.getVehicle().getQuantityPlaces()
                        ))
                        .availableSeats(trip.getVehicle().getQuantityPlaces())
                        .destination(trip.getArrivalLocation())
                        .departureTime(trip.getDepartureTime())
                        .departureLocation(trip.getDepartureLocation())
                        .estimatedArrivalTime(trip.getArrivalTime())
                        .departureLabel("Departure") // Ajuste conforme necessário
                        .arrivalLabel("Arrival") // Ajuste conforme necessário
                        .passengers(trip.getPassengers().stream()
                                .map(passenger -> new PassengerRequestCreateDTO(
                                        passenger.getId(),
                                        passenger.getName()
                                ))
                                .collect(Collectors.toList()))
                        .addresses(trip.getAddresses().stream()
                                .map(address -> new AddressRequestDTO(
                                        address.getId(),
                                        address.getAddress(),
                                        address.getNumber(),
                                        address.getNeighborhood()
                                ))
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}
