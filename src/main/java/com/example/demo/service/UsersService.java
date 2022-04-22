package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	@Lazy
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//Create one new user
	public Users createUser(Users users) {
		
		String encodedPassword = bCryptPasswordEncoder.encode(users.getPassword());
		
		users.setPassword(encodedPassword);
		
		return userRepository.save(users);
	}

	
	//Get one specific user
	public Users getUser(String userId) {
		
		Optional<Users> users = userRepository.findById(userId);
		
		if (users.isPresent() && userId != null) {
			return users.get();
		} else {
			return null;
		}
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users foundUser = userRepository.findByEmail(email);
		
		String userE = foundUser.getEmail();
		
		String userP = foundUser.getPassword();
		
		//This arrayList means authorities or rules
		return new User(userE, userP, new ArrayList<>());
	}

	// Get all users
	public List<Users> getUsers() {
		
		return userRepository.findAll();
	}



}
