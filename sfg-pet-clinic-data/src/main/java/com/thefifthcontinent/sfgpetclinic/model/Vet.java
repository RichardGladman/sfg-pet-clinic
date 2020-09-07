package com.thefifthcontinent.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Vets")
public class Vet extends Person {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "vets_specialites", 
			joinColumns = @JoinColumn(name = "vet_id"), 
			inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialties;
	
	@Builder
	public Vet(Long id, String givenName, String surname, Set<Speciality> specialities) {
		super(id, givenName, surname);
		this.specialties = specialities;
	}

	
	public void addSpeciality(Speciality speciality) {
		if (null == specialties) {
			specialties = new HashSet<>();
		}
		
		specialties.add(speciality);
	}
}
