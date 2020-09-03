package com.thefifthcontinent.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.model.Vet;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;
import com.thefifthcontinent.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner = new Owner(); 
		owner.setGivenName("Buffy");
		owner.setSurname("Summers");
		ownerService.save(owner);
		
		owner = new Owner();
		owner.setGivenName("Willow");
		owner.setSurname("Rosenberg");
		ownerService.save(owner);
		
		System.out.println("Loaded owners.");
		
		Vet vet = new Vet();
		vet.setGivenName("John");
		vet.setSurname("Doe");
		vetService.save(vet);
		
		vet = new Vet();
		vet.setGivenName("Freddie");
		vet.setSurname("Kruger");
		vetService.save(vet);
		
		System.out.println("Loaded vets.");
		
	}

}
