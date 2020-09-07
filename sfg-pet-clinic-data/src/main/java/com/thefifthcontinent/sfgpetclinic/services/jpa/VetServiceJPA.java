package com.thefifthcontinent.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Vet;
import com.thefifthcontinent.sfgpetclinic.repositories.VetRepository;
import com.thefifthcontinent.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetServiceJPA extends AbstractJPAService<Vet, VetRepository> implements VetService {

	public VetServiceJPA(VetRepository repository) {
		super(repository);
	}

}
