package com.rest.webservices.restfulwebservices.dto;

public class HelloWorldDto {
	private String message;

	public HelloWorldDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldDto [message=" + message + "]";
	}

}
