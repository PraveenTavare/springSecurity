package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.security.models.User;
import com.example.security.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityProjectApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		user.setEmail("john@gmail.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("Bangalore@123"));
		user.setUserName("john");
		user.setRole("ROLE_NORMAL");
		
		this.userRepository.save(user);
		
		User user1 = new User();
		user1.setEmail("anil@gmail.com");
		user1.setPassword(this.bCryptPasswordEncoder.encode("Bangalore@1234"));
		user1.setUserName("anil");
		user1.setRole("ROLE_ADMIN");
		
		this.userRepository.save(user1);
	}

}
