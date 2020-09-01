package com.thefifthcontinent.sfgpetclinic.services;

import java.util.Set;

import com.thefifthcontinent.sfgpetclinic.model.Pet;

public interface PetService {

	Set<Pet> find();
	Pet find(Long id);
	
	Pet save(Pet vet);
}
