package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Properties;
import com.example.demo.service.PropertiesService;

@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PropertiesController {
	
	
	@Autowired
	private PropertiesService propertiesService;
	
	// Post Property
	@PostMapping("/Properties")
	public ResponseEntity<Properties> addProperty(@RequestBody Properties properties){
		
		Properties p = propertiesService.createProperty(properties);
		
		return new ResponseEntity<Properties>(p, HttpStatus.CREATED);
	}
	
	
//	@GetMapping("/Properties")
//	public List<Properties> getAllProperties(){
//		
//		return propertiesService.getAllProperties();
//	}
	
//	@GetMapping("/Properties/typeortitle")
//	public ResponseEntity<List<Properties>> getAllPropertiesTypeOrTitle(@RequestParam String type, @RequestParam String title){
//		
//		return new ResponseEntity<>(propertiesService.getAllPropertiesTypeOrTitle(type, title), HttpStatus.OK);
//		
//	}
	
	
	// Get All Properties and by type and title
	@GetMapping("/Properties")
	public ResponseEntity<List<Properties>> getAllProperties(@RequestParam String type, @RequestParam String title){
		
		if(type == "" && title == "") {
			return new ResponseEntity<>(propertiesService.getAllProperties(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(propertiesService.getAllPropertiesTypeOrTitle(type, title), HttpStatus.OK);
		}
	}
	
	// Get All Best Seller Properties
	@GetMapping("/Properties/bestSeller")
	public ResponseEntity<List<Properties>> getPropertiesByBestSeller(){
		List<Properties> p = propertiesService.getPropertiesByBestSeller();
		
		if(null!=p) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
		}
		
	}
	
	// Get One Property
	@GetMapping("/Properties/{propertyId}")
	public ResponseEntity<Properties> getProperty(@PathVariable String propertyId){
		
		Properties p = propertiesService.getProperty(propertyId);
		
		if(null != p) {
			
			return new ResponseEntity<Properties>(p, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<Properties>(new Properties(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	//Update One Property
	@PutMapping("/Properties/{propertyId}")
	public ResponseEntity<Properties> updateProperty(@RequestBody Properties properties, @PathVariable String propertyId){
		
		properties.setId(propertyId);
		
		Properties p = propertiesService.getProperty(propertyId);
		
		Properties pro = propertiesService.createProperty(properties);
		
		if(null != p) {
			
			return new ResponseEntity<Properties>(pro, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<Properties>(pro, HttpStatus.CREATED);
					
		}
		
	}
	
	//Delete One Property
	@DeleteMapping("/Properties/{propertyId}")
	public ResponseEntity<String> deleteProperty(@PathVariable String propertyId){
		
		Properties p = propertiesService.getProperty(propertyId);
		
		if(null != p ) {
			
			propertiesService.deleteProperty(propertyId);
			
			return new ResponseEntity<String>("Property deleted: " + propertyId, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<String>("Property not deleted: " + propertyId, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
