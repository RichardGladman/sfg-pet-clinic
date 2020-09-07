package com.thefifthcontinent.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Speciality;
import com.thefifthcontinent.sfgpetclinic.services.SpecialityService;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
