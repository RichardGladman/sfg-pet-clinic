package com.thefifthcontinent.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.repositories.PetRepository;
import com.thefifthcontinent.sfgpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetServiceJPA extends AbstractJPAService<Pet, PetRepository> implements PetService {

	public PetServiceJPA(PetRepository repository) {
		super(repository);
	}

}
