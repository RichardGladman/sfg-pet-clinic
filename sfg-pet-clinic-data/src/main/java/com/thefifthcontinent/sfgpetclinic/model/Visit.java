package com.thefifthcontinent.sfgpetclinic.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Visits")
public class Visit extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "time")
	private LocalTime time;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
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
