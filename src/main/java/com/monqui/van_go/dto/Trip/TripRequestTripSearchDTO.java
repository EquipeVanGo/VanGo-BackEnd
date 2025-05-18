package com.monqui.van_go.dto.Trip;

public class TripRequestTripSearchDTO {
	private String departureLocation;
	private String arrivalLocation;

	public TripRequestTripSearchDTO() {
		super();
	}

	public TripRequestTripSearchDTO(String departureLocation, String arrivalLocation) {
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
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

}
