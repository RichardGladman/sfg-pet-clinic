package com.thefifthcontinent.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
