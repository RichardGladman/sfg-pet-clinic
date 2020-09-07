package com.thefifthcontinent.sfgpetclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Specialities")
public class Speciality extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "description")
	private String description;

}
