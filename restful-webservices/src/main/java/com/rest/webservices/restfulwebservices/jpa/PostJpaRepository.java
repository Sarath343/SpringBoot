package com.rest.webservices.restfulwebservices.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Integer>{
	 
}
