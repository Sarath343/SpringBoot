package com.rest.webservices.restfulwebservices.dto;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	
	private Integer id;
	@Size(min = 2,message = "Name should have ateast 2 Characters")
	private String name;
	@Past(message = "Birth date should be a past date")
	private LocalDate birthDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
