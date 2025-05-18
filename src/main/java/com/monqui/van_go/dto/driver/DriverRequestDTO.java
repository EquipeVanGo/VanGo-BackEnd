package com.monqui.van_go.dto.driver;

public class DriverRequestDTO {

	private Long id;
	private String name;
	private String phone;
	private String licenseNumber;

	public DriverRequestDTO() {
	}

	public DriverRequestDTO(Long id, String name, String phone, String licenseNumber) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.licenseNumber = licenseNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

}
