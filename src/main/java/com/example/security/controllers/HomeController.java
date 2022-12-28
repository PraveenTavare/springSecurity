package com.example.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		return "This is a home Page!!";
	}
	
	@GetMapping("/login")
	public String login() {
		return "This is a login Page!!";
	}
	
	@GetMapping("/register")
	public String register() {
		return "This is a register Page!!";
	}

}
