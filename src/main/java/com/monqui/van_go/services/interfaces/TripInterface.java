package com.monqui.van_go.services.interfaces;

import com.monqui.van_go.dto.Trip.TripRequestDTO;
import com.monqui.van_go.dto.Trip.TripResponseFindAddressesDTO;
import com.monqui.van_go.dto.Trip.TripResponseGenericDTO;

import java.util.List;

public interface TripInterface {

    List<TripResponseFindAddressesDTO> findAddresses(TripRequestDTO tripRequestDTO);

    List<TripResponseGenericDTO> findTrips(TripRequestDTO tripRequestDTO);
}
