package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;

@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsersController {
	
	@Autowired
	private UsersService userService;
	
	// Post new user
	@PostMapping("/Users")
	public ResponseEntity<Users> addUser(@RequestBody Users users){
		
		
		Users u = userService.createUser(users);
		
		return new ResponseEntity<Users>(u, HttpStatus.CREATED);
	}
	
	// Get All users
	@GetMapping("/Users")
	public ResponseEntity<List<Users>> getUsers() {

		List<Users> users = userService.getUsers();

		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}

	}
	
	//Get the specific user
	@GetMapping("/Users/{userId}")
	public ResponseEntity<Users> getUser(@PathVariable String userId){
		
		Users u = userService.getUser(userId);
		
		if(null!=u) {
			return new ResponseEntity<Users>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<Users>(new Users(), HttpStatus.NOT_FOUND);
		}
		
	}

}
