package com.rest.webservices.restfulwebservices.webcontollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.daoservice.SocialMediaDao;
import com.rest.webservices.restfulwebservices.dto.User;

@RestController
public class SocialMediaController {
	
	SocialMediaDao dao;
	
	
	public SocialMediaController(SocialMediaDao dao) {
		super();
		this.dao = dao;
	}
	
	
	
	@GetMapping(path="/users")
	public List<User> fetchAllUsers(){
		return dao.fetchAllUsers() ;
		
	}
	@GetMapping (path="/users/{id}")
	public User fetchAUser(@PathVariable int id) {
		return dao.fetchAUser(id);
	}
	@PostMapping(path="/users")
	public void createUser(@RequestBody User user) {
		dao.createUser(user);
	}
}
