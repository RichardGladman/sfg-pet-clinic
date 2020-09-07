package com.thefifthcontinent.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.model.PetType;
import com.thefifthcontinent.sfgpetclinic.model.Speciality;
import com.thefifthcontinent.sfgpetclinic.model.Vet;
import com.thefifthcontinent.sfgpetclinic.model.Visit;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;
import com.thefifthcontinent.sfgpetclinic.services.PetTypeService;
import com.thefifthcontinent.sfgpetclinic.services.SpecialityService;
import com.thefifthcontinent.sfgpetclinic.services.VetService;
import com.thefifthcontinent.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final OwnerService ownerService;
	private final VetService vetService;
	private final VisitService visitService;

	@Value("${petclinic.loadFreshData:#{'false'}}")
	boolean loadData;

	
	@Autowired
	public DataLoader(
			OwnerService ownerService, 
			VetService vetService, 
			PetTypeService petTypeService, 
			SpecialityService specialityService,
			VisitService visitService
		) {
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.visitService = visitService;
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		if (!loadData) {
			return;
		}
		
		System.out.println("Creating new dataset...");
				
		Map<String, PetType> petTypes = createPetTypes();
		Map<String, Speciality> specialitiesMap = createSpecialities();
		createOwners(petTypes);
		createVets(specialitiesMap);
		
		System.out.println("\tCompleted.");
		
	}
	
	
	private void createOwners(Map<String, PetType> petTypes) {
		
		System.out.println("\tCreating owners...");

		Owner owner = new Owner(); 
		owner.setGivenName("Buffy");
		owner.setSurname("Summers");
		owner.setAddress("1630 Revello Drive");
		owner.setCity("Sunnydale");
		owner.setPhoneNumber("(805) 555-8986");
		
		Pet pet = new Pet();
		pet.setPetType(petTypes.get("cat"));
		pet.setOwner(owner);
		pet.setBirthDate(LocalDate.now());
		pet.setName("Cally");
		owner.addPet(pet);
		
		ownerService.save(owner);
		
		Visit visit = new Visit();
		visit.setPet(pet);
		visit.setTime(LocalTime.now());
		visit.setDescription("Annual checkup");
		visitService.save(visit);
		
		owner = new Owner();
		owner.setGivenName("Willow");
		owner.setSurname("Rosenberg");
		owner.setAddress("Sunnydale U.");
		owner.setCity("Sunnydale");
		owner.setPhoneNumber("(805) 555-6789");
		
		pet = new Pet();
		pet.setPetType(petTypes.get("dog"));
		pet.setOwner(owner);
		pet.setBirthDate(LocalDate.now());
		pet.setName("Rover");
		owner.addPet(pet);
		
		ownerService.save(owner);
	}
	
	
	private void createVets(Map<String, Speciality> specialities) {
		
		System.out.println("\tCreating vets...");
		
		Vet vet = new Vet();
		vet.setGivenName("Jason");
		vet.setSurname("Vorhees");
		vet.addSpeciality(specialities.get("dentistry"));
		vet.addSpeciality(specialities.get("surgery"));
		vetService.save(vet);
		
		vet = new Vet();
		vet.setGivenName("Freddie");
		vet.setSurname("Kruger");
		vet.addSpeciality(specialities.get("radiology"));
		vetService.save(vet);
	}
	
	
	private Map<String, PetType> createPetTypes() {
		
		System.out.println("\tCreating pet types...");
	
		Map<String, PetType> petTypes = new HashMap<>();
		
		PetType type = new PetType();
		type.setName("Cat");
		petTypes.put("cat", petTypeService.save(type));
		
		type = new PetType();
		type.setName("Dog");
		petTypes.put("dog", petTypeService.save(type));
		
		type = new PetType();
		type.setName("Bird");
		petTypes.put("bird", petTypeService.save(type));
		
		type = new PetType();
		type.setName("Rabbit");
		petTypes.put("rabbit", petTypeService.save(type));
		
		return petTypes;
	}
	
	private Map<String, Speciality> createSpecialities() {
		
		System.out.println("\tCreating Specialities...");
		
		Map<String, Speciality> specialities = new HashMap<>();
		
		Speciality speciality = new Speciality();
		speciality.setDescription("Surgery");
		specialities.put("surgery", specialityService.save(speciality));
		
		speciality = new Speciality();
		speciality.setDescription("Diagnostics");
		specialities.put("diagnostics", specialityService.save(speciality));
		
		speciality = new Speciality();
		speciality.setDescription("Dentistry");
		specialities.put("dentistry", specialityService.save(speciality));
		
		speciality = new Speciality();
		speciality.setDescription("Radiology");
		specialities.put("radiology", specialityService.save(speciality));
		
		return specialities;
	}

}
