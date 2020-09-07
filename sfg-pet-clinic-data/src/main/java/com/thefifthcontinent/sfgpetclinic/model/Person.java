package com.thefifthcontinent.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Person extends BaseEntity {
	
	public Person(Long id, String givenName, String surname) {
		super(id);
		this.givenName = givenName;
		this.surname = surname;
	}

	private static final long serialVersionUID = 1L;
	
	@Column(name = "first_name")
	private String givenName;
	
	@Column(name = "last_name")
	private String surname;
	
}
