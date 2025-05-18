package com.monqui.van_go.dto.passenger;

public class PassengerResponseUpdateDTO {

	private Long id;
	private String age;
	private String name;
	private String email;
	private String telephone;

	public PassengerResponseUpdateDTO() {
	}

	public PassengerResponseUpdateDTO(Long id, String age, String name, String email, String telephone) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}

//Irei implementar correções dos métodos posteriormente para diminuir acoplamento
