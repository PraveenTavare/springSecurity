package com.example.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.security.models.User;

@Service
public class UserService {

	List<User> userList = new ArrayList<>();

	public UserService() {

		userList.add(new User("abc", "abc", "abc@gmail.com"));
		userList.add(new User("xyz", "abcxyz", "xyz@gmail.com"));
	}

	// get all users
	public List<User> getAllUsers() {

		return this.userList;
	}

	// get a user
	public User getUser(String username) {

		return this.userList.stream().
				filter(user -> user.getUserName().equals(username)).findAny().orElse(null);
	}
	
	//add new user
	public User addUser(User user) {

		this.userList.add(user);
		return user;
	}
	
	
	

}
