package com.thefifthcontinent.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "first_name")
	private String givenName;
	
	@Column(name = "last_name")
	private String surname;
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
