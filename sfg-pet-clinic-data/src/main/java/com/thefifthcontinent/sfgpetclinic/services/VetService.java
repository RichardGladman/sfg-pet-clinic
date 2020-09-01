package com.thefifthcontinent.sfgpetclinic.services;

import java.util.Set;

import com.thefifthcontinent.sfgpetclinic.model.Vet;

public interface VetService {

	Set<Vet> find();
	Vet find(Long id);
	Vet find(String surname);
	
	Vet save(Vet vet);
}
