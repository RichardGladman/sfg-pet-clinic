package com.thefifthcontinent.sfgpetclinic.services.map;


import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Vet;
import com.thefifthcontinent.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
}
