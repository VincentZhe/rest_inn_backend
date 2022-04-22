package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Properties;
import com.example.demo.repository.Repository;

@Service
public class PropertiesService {
	
	@Autowired
	public Repository repository;
	
	// Post new property
		public Properties createProperty(Properties properties) {
			
			return repository.save(properties);
		}

	//get all properties entity
	public List<Properties> getAllProperties() {
		
		return repository.findAll();
	}
	
	//get all properties by type and title
    public List<Properties> getAllPropertiesTypeOrTitle(String type, String title) {
		
		return repository.findByTypeOrTitle(type, title);
	}

	//get one property
	public Properties getProperty(String propertyId) {
		
		Optional<Properties> properties = repository.findById(propertyId);
		
		if(properties.isPresent()) {
			return properties.get();
		} else {
			return null;
		}
	}
	
	//update one property
	public Properties updateProperty(Properties properties) {
		
		return repository.save(properties);
		
	}
	
	//delete one property
	public void deleteProperty(String propertyId) {
		
		repository.deleteById(propertyId);
		
	}

	public List<Properties> getPropertiesByBestSeller() {
		
		List<Properties> proBestSeller = new ArrayList<>();
		
		for(Properties p : repository.findAll()) {
//			System.out.println(p.getBestSeller());
			
			if(p.getBestSeller()) {
				proBestSeller.add(p);
			}
		}
		
		return proBestSeller;
	}

	

	
	
	

	

}
