package com.thefifthcontinent.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Speciality;
import com.thefifthcontinent.sfgpetclinic.repositories.SpecialityRepository;
import com.thefifthcontinent.sfgpetclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialityServiceJPA extends AbstractJPAService<Speciality, SpecialityRepository> implements SpecialityService {

	public SpecialityServiceJPA(SpecialityRepository repository) {
		super(repository);
	}

}
