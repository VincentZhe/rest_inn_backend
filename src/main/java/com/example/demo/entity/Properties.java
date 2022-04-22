package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Properties")
public class Properties {
	
	
	@Id
	private String id;
	private String title;
	private String description;
	private Double price;
	private String type;
	private String houseRules;
	private String amenities;
	private String location;
	private String image;
	private Boolean bestSeller;
	private String mapAddress;
	
	public Properties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Properties(String id, String title, String description, Double price, String type, String houseRules,
			String amenities, String location, String image, Boolean bestSeller, String mapAddress) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.type = type;
		this.houseRules = houseRules;
		this.amenities = amenities;
		this.location = location;
		this.image = image;
		this.bestSeller = bestSeller;
		this.mapAddress = mapAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHouseRules() {
		return houseRules;
	}

	public void setHouseRules(String houseRules) {
		this.houseRules = houseRules;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(Boolean bestSeller) {
		this.bestSeller = bestSeller;
	}

	public String getMapAddress() {
		return mapAddress;
	}

	public void setMapAddress(String mapAddress) {
		this.mapAddress = mapAddress;
	}
	
	
	

}
