package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entities.enums.TripTypes;

public class TripRequestDTO {

	private Long idPassenger;
	private String departureLocation;
	private String arrivalLocation;
	private TripTypes tripTypes;
	
	

	public TripRequestDTO() {
	}

	public TripRequestDTO(Long idPassenger, String departureLocation, String arrivalLocation, TripTypes tripTypes) {
		this.idPassenger = idPassenger;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.tripTypes = tripTypes;
	}

	public Long getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public TripTypes getTripTypes() {
		return tripTypes;
	}

	public void setTripTypes(TripTypes tripTypes) {
		this.tripTypes = tripTypes;
	}

}
