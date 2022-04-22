package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Users;


public interface UserRepository extends MongoRepository<Users, String>{
	
	//This tells Mongo that there needs to be an implementation for this
	Users findByEmail(String email);

}
