package com.thefifthcontinent.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.services.OwnerService;

public class OwnerServiceMapTest {
	
	OwnerService ownerServiceMap;
	
	private final Long ownerId = 1L;
	private final String surname = "Smith";

	@BeforeEach
	protected void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).surname(surname).build());
	}

	@Test
	public void testSaveExisting() throws Exception {
		Owner owner = ownerServiceMap.findById(ownerId);
		String surname = "Watson";
		owner.setSurname(surname);
		owner = ownerServiceMap.save(owner);
		assertEquals(surname, owner.getSurname());
	}
	
	@Test
	public void testSaveNew() throws Exception {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().givenName("Lufifer").surname("Watson").build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	public void testFindByName() throws Exception {
		Owner owner = ownerServiceMap.findByName(surname);
		assertNotNull(owner);
		assertEquals(ownerId, owner.getId());
		assertEquals(surname, owner.getSurname());
	}

	@Test
	public void testFindByNameNotFound() throws Exception {
		Owner owner = ownerServiceMap.findByName("Watson");
		assertNull(owner);
	}

	@Test
	public void testFindAll() throws Exception {
		Set<Owner> owners = ownerServiceMap.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	public void testFindById() throws Exception {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	public void testDeleteById() throws Exception {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	public void testDelete() throws Exception {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

}
