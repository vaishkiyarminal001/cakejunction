package com.app.DTO;

import jakarta.persistence.Column;

public class DataDto {
	
private String name;
	
	@Column(columnDefinition = "TEXT")
	private String imageUrl;
	private String description;
	public DataDto(String name, String imageUrl, String description) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
	}
	public DataDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
