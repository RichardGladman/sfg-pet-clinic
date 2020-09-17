package com.thefifthcontinent.sfgpetclinic.services.jpa;

import com.thefifthcontinent.sfgpetclinic.model.Visit;
import com.thefifthcontinent.sfgpetclinic.repositories.VisitRepository;
import com.thefifthcontinent.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitServiceJPA extends AbstractJPAService<Visit, VisitRepository> implements VisitService {

	public VisitServiceJPA(VisitRepository repository) {
		super(repository);
	}

}
