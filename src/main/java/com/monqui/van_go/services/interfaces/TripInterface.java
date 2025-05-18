package com.monqui.van_go.services.interfaces;

import com.monqui.van_go.dto.Trip.TripRequestDTO;
import com.monqui.van_go.dto.Trip.TripResponseAddressDTO;
import com.monqui.van_go.dto.Trip.TripResponseGenericDTO;
import com.monqui.van_go.entities.location.Address;

import java.util.List;

public interface TripInterface {

    List<Address> findAddresses(TripRequestDTO tripRequestDTO);

    List<TripResponseGenericDTO> findTrips(TripRequestDTO tripRequestDTO);
}
