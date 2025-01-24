package com.rest.webservices.restfulwebservices.webcontollers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.rest.webservices.restfulwebservices.jpa.Post;
import com.rest.webservices.restfulwebservices.jpa.PostJpaRepository;
import com.rest.webservices.restfulwebservices.jpa.User;
import com.rest.webservices.restfulwebservices.jpa.UserJpaRepository;

@RestController
public class SocialMediaJpaController {

	UserJpaRepository jpaUserRepository;

	PostJpaRepository jpaPostRepository;

	public SocialMediaJpaController(UserJpaRepository dao, PostJpaRepository postDao) {
		super();
		this.jpaUserRepository = dao;
		this.jpaPostRepository = postDao;
	}

	@GetMapping(path = "/users/jpa")
	public List<User> fetchAllUsers() {
		return jpaUserRepository.findAll();

	}

	@GetMapping(path = "/users/jpa/{id}")
	public User fetchAUser(@PathVariable int id) {
		Optional<User> user = jpaUserRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("User with id " + id + " is not present");

		return user.get();
	}

	@PostMapping(path = "/users/jpa")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = jpaUserRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build(); // to return a specific http request back
	}

	@DeleteMapping(path = "/users/jpa/{id}")
	public void deleteUser(@PathVariable int id) {
		jpaUserRepository.deleteById(id);
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable Integer id, @RequestBody Post post) {
		Optional<User> userOp = jpaUserRepository.findById(id);
		User user = null ; 
		if (userOp.isPresent()) {
			Post createdPOst = jpaPostRepository.save(post);
			user = userOp.get();
			List<Post> exPosts = user.getPosts() ;
			exPosts.add(createdPOst);
			 user.setPosts(exPosts) ; 
			jpaUserRepository.save(user);
			return new ResponseEntity<Post>(createdPOst, HttpStatus.CREATED);
		}
		throw new UserNotFoundException("User with id " + id + " doesnt exists");
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> fetchPostsByUser(@PathVariable Integer id){
		Optional<User> user = jpaUserRepository.findById(id) ;
		if(user.isPresent()) {
			List<Post> posts = user.get().getPosts();
				return posts;
		}
		throw new  UserNotFoundException("User with id "+id+" doesnt exists") ; 
	}
	
	@DeleteMapping(path="/users/{id}/post/{postId}")
	public void deletePostById(@PathVariable Integer id , @PathVariable Integer postId) {
		Optional<Post> post = jpaPostRepository.findById(postId); 
		if(post.isPresent()) {
			jpaPostRepository.deleteById(postId);
		}
	}

}
