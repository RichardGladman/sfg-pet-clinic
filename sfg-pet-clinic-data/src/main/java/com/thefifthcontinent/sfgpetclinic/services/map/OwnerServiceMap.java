package com.thefifthcontinent.sfgpetclinic.services.map;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;
import com.thefifthcontinent.sfgpetclinic.services.PetService;
import com.thefifthcontinent.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}
	
	
	@Override
	public Owner save(Owner object) {

		if (null == object) {
			return null;
		}
		
		if (null != object.getPets()) {
			object.getPets().forEach(pet -> {
				if (null == pet.getPetType()) {
					throw new RuntimeException("Pet type is required");
				}
				
				if (null == pet.getPetType().getId()) {
					pet.setPetType(petTypeService.save(pet.getPetType()));
				}
				
				if (null == pet.getId()) {
					pet.setId(petService.save(pet).getId());
				}
			});
		}
		
		return super.save(object);
	}


	@Override
	public Owner findByName(String surname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
