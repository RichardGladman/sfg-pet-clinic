package com.thefifthcontinent.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

	private static final long serialVersionUID = 1L;
	
	private String address;
	private String city;
	private String phoneNumber;
	
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
