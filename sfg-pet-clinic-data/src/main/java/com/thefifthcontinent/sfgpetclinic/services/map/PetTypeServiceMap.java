package com.thefifthcontinent.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.PetType;
import com.thefifthcontinent.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
