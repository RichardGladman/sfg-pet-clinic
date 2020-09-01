package com.thefifthcontinent.sfgpetclinic.services;

import java.util.Set;

import com.thefifthcontinent.sfgpetclinic.model.Owner;

public interface OwnerService {

	Set<Owner> find();
	Owner find(Long id);
	Owner find(String surname);
	
	OwnerService save(Owner owner);
}
