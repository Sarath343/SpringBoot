package com.rest.webservices.restfulwebservices.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	public Post() {
		
	}
	public Post(Integer id, String description, Integer user) {
		super();
		this.id = id;
		this.description = description;
		this.userId = user;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	@ManyToOne
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	 
	
	
}
