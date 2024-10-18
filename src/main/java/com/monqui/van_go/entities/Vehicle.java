package com.monqui.van_go.entities;

import java.io.Serializable;
import java.util.Objects;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

//@Entity
//@Table(name = "tb_vehicle")
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;

	//@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String plate;
	private String color;
	private int year;
	private int quantityPlaces;
	
	public Vehicle() {
	}

	public Vehicle(Long id, String plate, String color, int year, int quantityPlaces) {
		this.id = id;
		this.plate = plate;
		this.color = color;
		this.year = year;
		this.quantityPlaces = quantityPlaces;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuantityPlaces() {
		return quantityPlaces;
	}

	public void setQuantityPlaces(int quantityPlaces) {
		this.quantityPlaces = quantityPlaces;
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
		Vehicle other = (Vehicle) obj;
		return Objects.equals(id, other.id);
	}
}
