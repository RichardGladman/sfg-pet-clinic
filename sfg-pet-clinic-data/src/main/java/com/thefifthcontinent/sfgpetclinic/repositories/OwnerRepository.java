package com.thefifthcontinent.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thefifthcontinent.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findBySurname(String surname);
	
}
