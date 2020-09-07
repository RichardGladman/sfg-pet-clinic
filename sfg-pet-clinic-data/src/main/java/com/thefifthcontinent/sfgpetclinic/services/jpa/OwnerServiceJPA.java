package com.thefifthcontinent.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.repositories.OwnerRepository;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerServiceJPA extends AbstractJPAService<Owner, OwnerRepository> implements OwnerService {
	
	public OwnerServiceJPA(OwnerRepository ownerRepository) {
		super(ownerRepository);
	}

	
	@Override
	public Owner findByName(String surname) {
		return repository.findBySurname(surname);
	}

}
