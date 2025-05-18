package com.monqui.van_go.dto.address;

public class AddressRequestDTO {
	private Long passengerId; // pode ser null se for "destination"
	private String type; // "pickup" ou "destination"
	private String address;
	private Double latitude;
	private Double longitude;
	private String estimatedPickupTime; // pode ser null se for "destination"

	public AddressRequestDTO() {
	}

	public AddressRequestDTO(Long id, String label, String street, String postalCode) {
	}

	public AddressRequestDTO(Long passengerId, String type, String address, Double latitude, Double longitude,
			String estimatedPickupTime) {
		super();
		this.passengerId = passengerId;
		this.type = type;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.estimatedPickupTime = estimatedPickupTime;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getEstimatedPickupTime() {
		return estimatedPickupTime;
	}

	public void setEstimatedPickupTime(String estimatedPickupTime) {
		this.estimatedPickupTime = estimatedPickupTime;
	}

}
