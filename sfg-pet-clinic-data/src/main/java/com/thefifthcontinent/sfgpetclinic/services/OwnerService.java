package com.thefifthcontinent.sfgpetclinic.services;

import java.util.List;

import com.thefifthcontinent.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner> {

	Owner findByName(String surname);
	List<Owner> findAllBySurnameLike(String surname);
	
}
