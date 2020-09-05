package com.thefifthcontinent.sfgpetclinic.model;

import java.time.LocalTime;

public class Visit extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private LocalTime time;
	private String description;
	private Pet pet;
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Pet getPet() {
		return pet;
	}
	
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
	public LocalTime getTime() {
		return time;
	}
	
	
	public void setTime(LocalTime time) {
		this.time = time;
	}

}
