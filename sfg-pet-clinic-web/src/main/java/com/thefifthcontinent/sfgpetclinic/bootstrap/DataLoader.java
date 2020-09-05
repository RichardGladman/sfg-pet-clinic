package com.thefifthcontinent.sfgpetclinic.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
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
		
		Set<PetType> petTypes = createPetTypes();
		createOwners();
		createVets();
		
	}
	
	
	private void createOwners() {
		
		System.out.println("Creating owners...");

		Owner owner = new Owner(); 
		owner.setGivenName("Buffy");
		owner.setSurname("Summers");
		ownerService.save(owner);
		
		owner = new Owner();
		owner.setGivenName("Willow");
		owner.setSurname("Rosenberg");
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
	
	
	private Set<PetType> createPetTypes() {
		
		System.out.println("Creating pet types...");
	
		Set<PetType> petTypes = new HashSet<>();
		
		PetType type = new PetType();
		type.setName("Cat");
		petTypes.add(petTypeService.save(type));
		
		type = new PetType();
		type.setName("Dog");
		petTypes.add(petTypeService.save(type));
		
		type = new PetType();
		type.setName("Bird");
		petTypes.add(petTypeService.save(type));
		
		type = new PetType();
		type.setName("Rabbit");
		petTypes.add(petTypeService.save(type));
		
		System.out.println("Created pet types.");
		
		return petTypes;
	}

}
