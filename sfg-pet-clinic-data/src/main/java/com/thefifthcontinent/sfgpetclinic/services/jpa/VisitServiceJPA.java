package com.thefifthcontinent.sfgpetclinic.services.jpa;

import com.thefifthcontinent.sfgpetclinic.model.Visit;
import com.thefifthcontinent.sfgpetclinic.repositories.VisitRepository;
import com.thefifthcontinent.sfgpetclinic.services.VisitService;

public class VisitServiceJPA extends AbstractJPAService<Visit, VisitRepository> implements VisitService {

	public VisitServiceJPA(VisitRepository repository) {
		super(repository);
	}

}
