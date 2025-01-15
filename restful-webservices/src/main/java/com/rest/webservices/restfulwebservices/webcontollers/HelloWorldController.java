package com.rest.webservices.restfulwebservices.webcontollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.dto.HelloWorldDto;
@RestController
public class HelloWorldController {
	@GetMapping(path="/helloWorld")
	public HelloWorldDto hello() {
		return new  HelloWorldDto("Hello World");
	}
	@GetMapping(path="/hello/path/{message}")
	public HelloWorldDto helloPath(@PathVariable String message) {
		return new HelloWorldDto(message);
	}
	
}
