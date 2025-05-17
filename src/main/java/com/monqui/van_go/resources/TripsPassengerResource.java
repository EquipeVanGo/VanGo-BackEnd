package com.monqui.van_go.resources;

import com.monqui.van_go.dto.Trip.TripRequestCreateDTO;
import com.monqui.van_go.dto.Trip.TripRequestDTO;
import com.monqui.van_go.dto.Trip.TripResponseAddressDTO;
import com.monqui.van_go.dto.Trip.TripResponseGenericDTO;
import com.monqui.van_go.entities.Trips;
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
    public ResponseEntity<List<TripResponseAddressDTO>> searchAddresses(
            @RequestParam Long idPassenger,
            @RequestParam String partialAddress,
            @RequestParam("one-way-trip") boolean oneWayTrip
    ) {
        TripRequestDTO requestDTO = TripRequestDTO.builder()
                .arrivalLocation(partialAddress)
                .build();

        List<TripResponseAddressDTO> response = tripService.findAddresses(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/search-trips")
    public ResponseEntity<List<TripResponseGenericDTO>> searchTrips(
            @RequestParam String departureLocation,
            @RequestParam String arrivalLocation
    ) {
        TripRequestDTO requestDTO = TripRequestDTO.builder()
                .departureLocation(departureLocation)
                .arrivalLocation(arrivalLocation)
                .build();

        List<TripResponseGenericDTO> response = tripService.findTrips(requestDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Trips> tripCreate(@RequestBody TripRequestCreateDTO tripRequestDTO) {
        Trips trips = tripService.insert(tripRequestDTO);
        return ResponseEntity.ok(trips);
    }
}
