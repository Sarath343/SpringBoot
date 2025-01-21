package com.rest.webservices.restfulwebservices.daoservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rest.webservices.restfulwebservices.dto.User;

@Component
public class SocialMediaDao {
	private static List<User> users = new ArrayList<>();
	 static int id = 0;
	 static {
		
		users.add(new User(++id, "Sasi", LocalDate.now().minusYears(30)));
		users.add(new User(++id, "Ravi", LocalDate.now().minusYears(35)));
		users.add(new User(++id, "Appu", LocalDate.now().minusYears(40)));

	}

	public List<User> fetchAllUsers() {
		return users;
	}

	public User fetchAUser(int id) {
		Predicate<? super User> predicate = user->user.getId().equals(id);
		return users.stream().filter(predicate ).findFirst().isPresent()  ? 
				users.stream().filter(predicate ).findFirst().get() : null
				;
	}

	public User createUser(User user) {
		user.setId(++id);
		users.add(user);
		return user;
	}

	public void deleteuser(int id2) {
		Predicate<? super User> predicate = user->user.getId().equals(id2);
		users.removeIf(predicate );
	}

}











