package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UsersService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsersService usersService;
	
	
	// This allow us to configure authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(usersService);
		
		
	}

	
	// This allow us to configure authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http.csrf().disable().authorizeRequests()
		.antMatchers("/Users/**").permitAll()
		.antMatchers("/Properties/**").permitAll()
		.antMatchers("/auth").permitAll()
		.anyRequest().authenticated();

			
		}
		
	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
			
			return super.authenticationManager();
			
		}
	
	//Bcrypt
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
			
			return new BCryptPasswordEncoder();
			
		}
	
}
