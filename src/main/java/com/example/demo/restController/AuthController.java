package com.example.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	
	@PostMapping("/auth")
	public ResponseEntity<Users> login(@RequestBody Users users){
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getEmail(), users.getPassword()));
			
			
			return new ResponseEntity<Users>(users, HttpStatus.OK);
			
			
		} catch(BadCredentialsException badCredentialsException) {
			
			return new ResponseEntity<Users>(users, HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
}
