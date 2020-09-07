package com.thefifthcontinent.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.PetType;
import com.thefifthcontinent.sfgpetclinic.repositories.PetTypeRepository;
import com.thefifthcontinent.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeServiceJPA extends AbstractJPAService<PetType, PetTypeRepository> implements PetTypeService {

	public PetTypeServiceJPA(PetTypeRepository repository) {
		super(repository);
	}

}
