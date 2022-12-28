package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserName(String username);

}
