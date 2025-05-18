package com.monqui.van_go.dto.Trip;

public class TripResponseAddressDTO {

	private Long id;
	private String label;
	private String streetAddress;
	private String postalCode;
	private String number;
	private String complement;
	
	

	public TripResponseAddressDTO() {
	}

	public TripResponseAddressDTO(Long id, String label, String streetAddress, String postalCode, String number,
			String complement) {
		this.id = id;
		this.label = label;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.number = number;
		this.complement = complement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

}
