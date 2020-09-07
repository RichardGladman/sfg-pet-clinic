package com.thefifthcontinent.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.services.PetService;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
