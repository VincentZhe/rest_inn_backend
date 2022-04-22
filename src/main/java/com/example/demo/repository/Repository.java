package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Properties;

public interface Repository extends MongoRepository<Properties, String>{

	List<Properties> findByTypeOrTitle(String type, String title);
}
