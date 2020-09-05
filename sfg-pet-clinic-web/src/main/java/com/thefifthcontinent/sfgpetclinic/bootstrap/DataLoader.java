package com.thefifthcontinent.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.model.Pet;
import com.thefifthcontinent.sfgpetclinic.model.PetType;
import com.thefifthcontinent.sfgpetclinic.model.Vet;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;
import com.thefifthcontinent.sfgpetclinic.services.PetTypeService;
import com.thefifthcontinent.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final PetTypeService petTypeService;
	private final OwnerService ownerService;
	private final VetService vetService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		Map<String, PetType> petTypes = createPetTypes();
		createOwners(petTypes);
		createVets();
		
	}
	
	
	private void createOwners(Map<String, PetType> petTypes) {
		
		System.out.println("Creating owners...");

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
		
		System.out.println("Created owners.");
	}
	
	
	private void createVets() {
		
		System.out.println("Creating vets...");
		
		Vet vet = new Vet();
		vet.setGivenName("John");
		vet.setSurname("Doe");
		vetService.save(vet);
		
		vet = new Vet();
		vet.setGivenName("Freddie");
		vet.setSurname("Kruger");
		vetService.save(vet);
		
		System.out.println("Created vets.");
	}
	
	
	private Map<String, PetType> createPetTypes() {
		
		System.out.println("Creating pet types...");
	
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
		
		System.out.println("Created pet types.");
		
		return petTypes;
	}

}
