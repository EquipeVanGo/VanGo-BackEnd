package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entities.Driver;
import com.monqui.van_go.entities.Enterprise;
import com.monqui.van_go.entities.Vehicle;

public class TripRequestCreateDTO {

	private Long tripId;
	private Enterprise enterpriseId;
	private Driver driver;
	private Vehicle vehicle;
	private String departureLocation;
	private String departureTime;
	private String arrivalLocation;
	private String arrivalTime;
	private String pngRoute;
	
	

	public TripRequestCreateDTO() {
	}

	public TripRequestCreateDTO(Long tripId, Enterprise enterpriseId, Driver driver, Vehicle vehicle,
			String departureLocation, String departureTime, String arrivalLocation, String arrivalTime,
			String pngRoute) {
		this.tripId = tripId;
		this.enterpriseId = enterpriseId;
		this.driver = driver;
		this.vehicle = vehicle;
		this.departureLocation = departureLocation;
		this.departureTime = departureTime;
		this.arrivalLocation = arrivalLocation;
		this.arrivalTime = arrivalTime;
		this.pngRoute = pngRoute;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Enterprise getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Enterprise enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getPngRoute() {
		return pngRoute;
	}

	public void setPngRoute(String pngRoute) {
		this.pngRoute = pngRoute;
	}

}
