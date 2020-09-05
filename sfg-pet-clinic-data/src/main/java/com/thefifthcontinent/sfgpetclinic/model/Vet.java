package com.thefifthcontinent.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

	private static final long serialVersionUID = 1L;
	
	private Set<Speciality> specialties;

	
	public Set<Speciality> getSpecialties() {
		return specialties;
	}

	
	public void setSpecialties(Set<Speciality> specialties) {
		this.specialties = specialties;
	}
	
	
	public void addSpeciality(Speciality speciality) {
		if (null == specialties) {
			specialties = new HashSet<>();
		}
		
		specialties.add(speciality);
	}
}
