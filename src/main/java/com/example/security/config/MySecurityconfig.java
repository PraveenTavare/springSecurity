package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityconfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().
		antMatchers("/public/**").hasRole("NORMAL").
		antMatchers("/users/**").hasRole("ADMIN").
			anyRequest().authenticated().and().httpBasic();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passEncoder());

		// For InMemoryAuthentication
		
//		auth.inMemoryAuthentication().withUser("john").
//			password(this.passEncoder().encode("Bangalore@123")).roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("anil").
//			password(this.passEncoder().encode("Bangalore@1234")).roles("ADMIN");
	}
	
	@Bean
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	

}
