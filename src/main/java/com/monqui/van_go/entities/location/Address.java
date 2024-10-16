package com.monqui.van_go.entities.location;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String city;
	private String state;
	private String number;
	private String address;

	public Address() {
	}

	public Address(Long id, String city, String state, String number, String address) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.number = number;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
}
