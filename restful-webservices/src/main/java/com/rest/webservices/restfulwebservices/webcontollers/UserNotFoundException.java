package com.rest.webservices.restfulwebservices.webcontollers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	
	public UserNotFoundException(String message) {
		super(message);
	
	}

}
