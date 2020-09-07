package com.thefifthcontinent.sfgpetclinic.services;

import com.thefifthcontinent.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner> {

	Owner findByName(String surname);
	
}
