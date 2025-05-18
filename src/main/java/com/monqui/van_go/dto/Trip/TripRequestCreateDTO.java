package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entities.Driver;
import com.monqui.van_go.entities.Enterprise;
import com.monqui.van_go.entities.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TripRequestCreateDTO {

	private Long tripId;
	private Enterprise enterpriseId;
	private Driver driver;
	private Vehicle vehicle;
	private String departureLocation;
	private LocalDateTime departureTime;
	private String departureLabel;
	private String arrivalLocation;
	private LocalDateTime arrivalTime;
	private String ArrivalLabel;
	private String pngRoute;
	
	

	public TripRequestCreateDTO() {
	}

	public TripRequestCreateDTO(Long tripId, Enterprise enterpriseId, Driver driver, Vehicle vehicle,
			String departureLocation, LocalDateTime departureTime, String arrivalLocation, LocalDateTime arrivalTime,
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

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getDepartureLabel() {
		return departureLabel;
	}

	public void setDepartureLabel(String departureLabel) {
		this.departureLabel = departureLabel;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getArrivalLabel() {
		return ArrivalLabel;
	}

	public void setArrivalLabel(String arrivalLabel) {
		this.ArrivalLabel = arrivalLabel;
	}

	public String getPngRoute() {
		return pngRoute;
	}

	public void setPngRoute(String pngRoute) {
		this.pngRoute = pngRoute;
	}

}
