package com.thefifthcontinent.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Visit;
import com.thefifthcontinent.sfgpetclinic.services.VisitService;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

}
