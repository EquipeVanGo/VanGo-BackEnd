package com.monqui.van_go.controller;

import com.monqui.van_go.dto.Trip.TripRequestDTO;
import com.monqui.van_go.dto.Trip.TripResponseAddressDTO;
import com.monqui.van_go.entity.enums.TripTypes;
import com.monqui.van_go.services.interfaces.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/passengers/trips")
public class TripsPassengerResource {

    @Autowired
    private TripsService tripsService;

    // URL esperada: /v1/passengers/trips?id=12&date=2025-04-21&destination_to=u-1&destination_from=p-2&one-way-trip=true
    @GetMapping(value = "")
    public ResponseEntity<List<TripResponseAddressDTO>> destiny(
            @RequestParam Long id,
            @RequestParam String date,
            @RequestParam("destination_to") String destinationTo,
            @RequestParam("destination_from") String destinationFrom,
            @RequestParam("one-way-trip") boolean oneWayTrip
    ) {
        TripTypes tipoViagem = oneWayTrip ? TripTypes.UNICA : TripTypes.RECORRENTE;
        TripRequestDTO requestDTO = new TripRequestDTO(id, destinationTo, destinationFrom, tipoViagem);
        List<TripResponseAddressDTO> response = tripsService.destination(requestDTO);
        return ResponseEntity.ok(response);
    }
}
