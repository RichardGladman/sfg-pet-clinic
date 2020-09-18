package com.thefifthcontinent.sfgpetclinic.services.map;


import com.thefifthcontinent.sfgpetclinic.model.Vet;
import com.thefifthcontinent.sfgpetclinic.services.SpecialityService;
import com.thefifthcontinent.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
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
		
		object.getSpecialities().forEach(speciality -> {
			if (null == speciality.getId()) {
				speciality.setId(specialityService.save(speciality).getId());
			}
		});

		return super.save(object);
	}
}
