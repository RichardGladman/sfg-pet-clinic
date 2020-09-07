package com.thefifthcontinent.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Visit;
import com.thefifthcontinent.sfgpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

}
