package com.thefifthcontinent.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.repositories.OwnerRepository;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerServiceJPA implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	
	
	public OwnerServiceJPA(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

	
	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	
	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	
	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	
	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	
	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	
	@Override
	public Owner findByName(String surname) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(surname);
	}

}
