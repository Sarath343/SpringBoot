package com.rest.webservices.restfulwebservices.webcontollers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservices.daoservice.SocialMediaDao;
import com.rest.webservices.restfulwebservices.dto.User;
import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class SocialMediaController {

	SocialMediaDao dao;

	public SocialMediaController(SocialMediaDao dao) {
		super();
		this.dao = dao;
	}

	@GetMapping(path = "/users")
	public List<User> fetchAllUsers() {
		return dao.fetchAllUsers();

	}

	@GetMapping(path = "/users/{id}")
	public User fetchAUser(@PathVariable int id) {
		User user = dao.fetchAUser(id);
		if (user == null)
			throw new UserNotFoundException("User with id "+id+" is not present");

		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody  User user) {
		User savedUser = dao.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build(); // to return a specific http request back
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		 dao.deleteuser(id);
	}
	
	//versioning by request parameter | req will be /getdat?version=1
	@GetMapping(path="/getData" ,  params="version=1")
	public String getFirstVersion(){
		return new String("This is from version 1");
	}
	@GetMapping(path="/getData" ,  params="version=2")
	public String getSecondVersion(){
		return new String("This is from version 2");
	}
}
