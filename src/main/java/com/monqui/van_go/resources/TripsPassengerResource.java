package com.monqui.van_go.resources;

import com.monqui.van_go.dto.Trip.*;
import com.monqui.van_go.dto.passenger.PassengerRequestTripsDTO;
import com.monqui.van_go.entities.Trips;
import com.monqui.van_go.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/trips")
public class TripsPassengerResource {

	@Autowired
	private TripService tripService;

	@GetMapping(value = "/passenger/addresses")
	public ResponseEntity<List<TripResponseFindAddressesDTO>> searchAddresses(@RequestParam("id") Long idPassenger,
			@RequestParam("destination") String partialAddress, @RequestParam("one-way-trip") boolean oneWayTrip) {

		TripRequestDTO requestDTO = new TripRequestDTO(idPassenger, partialAddress, partialAddress, oneWayTrip);

		List<TripResponseFindAddressesDTO> response = tripService.findAddresses(requestDTO);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/passenger/search-trips")
	public ResponseEntity<List<TripResponseGenericDTO>> searchTrips(@RequestParam("destination_to") String departureLocation,
			@RequestParam("destination_from") String arrivalLocation,@RequestParam("one-way-trip") boolean oneWayTrip) {
		TripRequestDTO requestDTO = new TripRequestDTO(null, departureLocation, arrivalLocation, oneWayTrip);

		List<TripResponseGenericDTO> response = tripService.findTrips(requestDTO);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/passenger/insert-passenger")
	public ResponseEntity<Boolean> insertPassenger(@RequestBody PassengerRequestTripsDTO dto) {
		Boolean result = tripService.insertPassengerOnTrip(dto);
		if (result) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(false);
		}
	}

	@PostMapping
	public ResponseEntity<TripResponseCreatedDTO> tripCreate(@RequestBody TripRequestCreateDTO tripRequestDTO) {
		Trips trip = tripService.tripsCreate(tripRequestDTO);
		TripResponseCreatedDTO responseDTO = new TripResponseCreatedDTO(trip);
		return ResponseEntity.ok(responseDTO);
	}

	@GetMapping("/driver/{driverId}")
	public ResponseEntity<List<TripByDriverDTO>> getTripsByDriver(@PathVariable Long driverId) {
		List<TripByDriverDTO> trips = tripService.getTripsByDriverId(driverId);
		return ResponseEntity.ok(trips);
	}

	@GetMapping("/passenger/{passengerId}")
	public ResponseEntity<List<TripByPassengerDTO>> getTripsByPassenger(@PathVariable Long passengerId) {
		List<TripByPassengerDTO> trips = tripService.getTripsByPassengerId(passengerId);
		return ResponseEntity.ok(trips);
	}

}
