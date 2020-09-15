package com.thefifthcontinent.sfgpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thefifthcontinent.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findBySurname(String surname);
	List<Owner> findAllBySurnameLike(String surname);
	
}
