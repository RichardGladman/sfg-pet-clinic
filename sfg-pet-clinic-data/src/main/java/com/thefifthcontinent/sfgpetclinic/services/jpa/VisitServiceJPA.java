package com.thefifthcontinent.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Visit;
import com.thefifthcontinent.sfgpetclinic.repositories.VisitRepository;
import com.thefifthcontinent.sfgpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitServiceJPA extends AbstractJPAService<Visit, VisitRepository> implements VisitService {

	public VisitServiceJPA(VisitRepository repository) {
		super(repository);
	}

}
