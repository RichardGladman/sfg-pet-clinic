package com.thefifthcontinent.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pets")
public class Pet extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>(); 
	
	public PetType getPetType() {
		return petType;
	}
	
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	
	public Set<Visit> getVisits() {
		return visits;
	}


	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	

}
