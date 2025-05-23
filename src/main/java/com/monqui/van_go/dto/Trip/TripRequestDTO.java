package com.monqui.van_go.dto.Trip;

public class TripRequestDTO {

	private Long idPassenger;
	private String departureLocation;
	private String arrivalLocation;
	private boolean tripTypes;
	
	

	public TripRequestDTO() {
	}

	public TripRequestDTO(Long idPassenger, String departureLocation, String arrivalLocation, boolean tripTypes) {
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

	public boolean getTripTypes() {
		return tripTypes;
	}

	public void setTripTypes(boolean tripTypes) {
		this.tripTypes = tripTypes;
	}

}
