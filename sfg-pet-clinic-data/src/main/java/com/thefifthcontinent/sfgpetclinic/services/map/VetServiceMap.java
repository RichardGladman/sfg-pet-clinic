package com.thefifthcontinent.sfgpetclinic.services.map;


import org.springframework.stereotype.Service;

import com.thefifthcontinent.sfgpetclinic.model.Vet;
import com.thefifthcontinent.sfgpetclinic.services.SpecialityService;
import com.thefifthcontinent.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
	private final SpecialityService specialityService;
	
		
	public VetServiceMap(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}



	@Override
	public Vet save(Vet object) {

		if (null == object) {
			return null;
		}
		
		object.getSpecialties().forEach(speciality -> {
			if (null == speciality.getId()) {
				speciality.setId(specialityService.save(speciality).getId());
			}
		});

		return super.save(object);
	}
}
