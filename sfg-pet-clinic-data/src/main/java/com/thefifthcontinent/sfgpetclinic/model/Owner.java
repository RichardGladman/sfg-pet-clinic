package com.thefifthcontinent.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Owners")
public class Owner extends Person {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets;

	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Set<Pet> getPets() {
		return pets;
	}

	
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
	
	public void addPet(Pet pet) {
		if (null == pets) {
			pets = new HashSet<>();
		}
		
		pets.add(pet);
	}
	

}
