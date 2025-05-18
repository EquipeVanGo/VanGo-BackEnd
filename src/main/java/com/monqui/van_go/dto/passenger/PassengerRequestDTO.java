package com.monqui.van_go.dto.passenger;

public class PassengerRequestDTO {

	private String email;
	private String password;
	private Long token;

	public PassengerRequestDTO() {
	}

	public PassengerRequestDTO(String email, String password, Long token) {
		this.email = email;
		this.password = password;
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

}
