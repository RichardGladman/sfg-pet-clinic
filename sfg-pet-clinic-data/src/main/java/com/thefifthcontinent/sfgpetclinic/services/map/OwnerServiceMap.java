package com.thefifthcontinent.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


	@Override
	public Owner findByName(String surname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
