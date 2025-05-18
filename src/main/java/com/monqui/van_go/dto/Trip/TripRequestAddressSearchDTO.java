package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entities.enums.TripTypes;

public class TripRequestAddressSearchDTO {

	private Long idPassenger;
	private String partialAddress;
	private TripTypes tripType;
	
	

	public TripRequestAddressSearchDTO() {
	}

	public TripRequestAddressSearchDTO(Long idPassenger, String partialAddress, TripTypes tripType) {
		this.idPassenger = idPassenger;
		this.partialAddress = partialAddress;
		this.tripType = tripType;
	}

	public Long getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public String getPartialAddress() {
		return partialAddress;
	}

	public void setPartialAddress(String partialAddress) {
		this.partialAddress = partialAddress;
	}

	public TripTypes getTripType() {
		return tripType;
	}

	public void setTripType(TripTypes tripType) {
		this.tripType = tripType;
	}

}
