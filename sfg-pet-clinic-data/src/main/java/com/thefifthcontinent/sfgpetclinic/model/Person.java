package com.thefifthcontinent.sfgpetclinic.model;

public class Person extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String givenName;
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
