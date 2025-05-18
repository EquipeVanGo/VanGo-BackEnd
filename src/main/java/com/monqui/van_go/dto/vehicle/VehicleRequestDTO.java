package com.monqui.van_go.dto.vehicle;

public class VehicleRequestDTO {
	private Long id;
	private String model;
	private String plate;
	private Integer seats;

	public VehicleRequestDTO() {
	}

	public VehicleRequestDTO(Long id, String model, String plate, Integer seats) {
		this.id = id;
		this.model = model;
		this.plate = plate;
		this.seats = seats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

}
