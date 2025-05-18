package com.monqui.van_go.resources;

import com.monqui.van_go.dto.Trip.*;
import com.monqui.van_go.entities.Trips;
import com.monqui.van_go.entities.location.Address;
import com.monqui.van_go.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/passengers/trips")
public class TripsPassengerResource {

	@Autowired
	private TripService tripService;

	@GetMapping(value = "/addresses")
	public ResponseEntity<List<TripResponseFindAddressesDTO>> searchAddresses(@RequestParam("id") Long idPassenger,
			@RequestParam("destination") String partialAddress, @RequestParam("one-way-trip") boolean oneWayTrip) {

		TripRequestDTO requestDTO = new TripRequestDTO(idPassenger, partialAddress, partialAddress, oneWayTrip);

		List<TripResponseFindAddressesDTO> response = tripService.findAddresses(requestDTO);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/search-trips")
	public ResponseEntity<List<TripResponseGenericDTO>> searchTrips(@RequestParam String departureLocation,
			@RequestParam String arrivalLocation,@RequestParam("one-way-trip") boolean oneWayTrip) {
		TripRequestDTO requestDTO = new TripRequestDTO(null, departureLocation, arrivalLocation, oneWayTrip);


		List<TripResponseGenericDTO> response = tripService.findTrips(requestDTO);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<Trips> tripCreate(@RequestBody TripRequestCreateDTO tripRequestDTO) {
		Trips trips = tripService.insert(tripRequestDTO);
		return ResponseEntity.ok(trips);
	}
}
