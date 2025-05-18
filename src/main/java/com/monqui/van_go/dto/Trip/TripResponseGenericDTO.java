package com.monqui.van_go.dto.Trip;

import java.util.List;

import com.monqui.van_go.dto.address.AddressRequestDTO;
import com.monqui.van_go.dto.driver.DriverRequestDTO;
import com.monqui.van_go.dto.passenger.PassengerRequestCreateDTO;
import com.monqui.van_go.dto.vehicle.VehicleRequestDTO;

public class TripResponseGenericDTO {
	private Long tripId;
	private Long enterpriseId;
	private String pngRoute;
	private DriverRequestDTO driver;
	private VehicleRequestDTO vehicle;
	private Integer availableSeats;
	private String destination;
	private String departureTime;
	private String departureLocation;
	private String arrivalLocation;
	private String estimatedArrivalTime;
	private String departureLabel;
	private String arrivalLabel;
	private List<PassengerRequestCreateDTO> passengers;
	private List<AddressRequestDTO> addresses;

	public TripResponseGenericDTO() {
	}

	public TripResponseGenericDTO(Long tripId, Long enterpriseId, String pngRoute, DriverRequestDTO driver,
			VehicleRequestDTO vehicle, Integer availableSeats, String destination, String departureTime,
			String departureLocation, String arrivalLocation, String estimatedArrivalTime, String departureLabel,
			String arrivalLabel, List<PassengerRequestCreateDTO> passengers, List<AddressRequestDTO> addresses) {
		this.tripId = tripId;
		this.enterpriseId = enterpriseId;
		this.pngRoute = pngRoute;
		this.driver = driver;
		this.vehicle = vehicle;
		this.availableSeats = availableSeats;
		this.destination = destination;
		this.departureTime = departureTime;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.estimatedArrivalTime = estimatedArrivalTime;
		this.departureLabel = departureLabel;
		this.arrivalLabel = arrivalLabel;
		this.passengers = passengers;
		this.addresses = addresses;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getPngRoute() {
		return pngRoute;
	}

	public void setPngRoute(String pngRoute) {
		this.pngRoute = pngRoute;
	}

	public DriverRequestDTO getDriver() {
		return driver;
	}

	public void setDriver(DriverRequestDTO driver) {
		this.driver = driver;
	}

	public VehicleRequestDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleRequestDTO vehicle) {
		this.vehicle = vehicle;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
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

	public String getEstimatedArrivalTime() {
		return estimatedArrivalTime;
	}

	public void setEstimatedArrivalTime(String estimatedArrivalTime) {
		this.estimatedArrivalTime = estimatedArrivalTime;
	}

	public String getDepartureLabel() {
		return departureLabel;
	}

	public void setDepartureLabel(String departureLabel) {
		this.departureLabel = departureLabel;
	}

	public String getArrivalLabel() {
		return arrivalLabel;
	}

	public void setArrivalLabel(String arrivalLabel) {
		this.arrivalLabel = arrivalLabel;
	}

	public List<PassengerRequestCreateDTO> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerRequestCreateDTO> passengers) {
		this.passengers = passengers;
	}

	public List<AddressRequestDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressRequestDTO> addresses) {
		this.addresses = addresses;
	}

}
