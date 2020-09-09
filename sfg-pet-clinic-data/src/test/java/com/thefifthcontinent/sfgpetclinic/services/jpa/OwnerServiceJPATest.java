package com.thefifthcontinent.sfgpetclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thefifthcontinent.sfgpetclinic.model.Owner;
import com.thefifthcontinent.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceJPATest {
	
	private static final long OWNER_ID = 1L;

	private static final String LAST_NAME = "Smith";

	@Mock
	OwnerRepository repository;
	
	@InjectMocks
	OwnerServiceJPA service;

	@BeforeEach
	protected void setUp() throws Exception {
	}

	@Test
	public void testFindByName() throws Exception {
		
		Owner owner = Owner.builder().id(OWNER_ID).surname(LAST_NAME).build();
		when(repository.findBySurname(anyString())).thenReturn(owner);
		Owner found = service.findByName(LAST_NAME);
		
		assertEquals(LAST_NAME, found.getSurname());
		verify(repository).findBySurname(anyString());
		
	}

	@Test
	public void testFindById() throws Exception {
		
		Owner owner = Owner.builder().id(OWNER_ID).surname(LAST_NAME).build();
		when(repository.findById(anyLong())).thenReturn(Optional.of(owner));
		Owner found = service.findById(OWNER_ID);
		
		assertNotNull(found);
		
	}

	@Test
	public void testFindByIdNotFound() throws Exception {
		
		when(repository.findById(anyLong())).thenReturn(Optional.empty());
		Owner found = service.findById(OWNER_ID);
		
		assertNull(found);
		
	}

	@Test
	public void testFindAll() throws Exception {
		
		Set<Owner> owners = new HashSet<>();
		owners.add(Owner.builder().id(OWNER_ID).build());
		owners.add(Owner.builder().id(OWNER_ID + 1).build());
		when(repository.findAll()).thenReturn(owners);
		
		Set<Owner> found = service.findAll();
		
		assertEquals(2L, found.size());
		verify(repository).findAll();
	}

	@Test
	public void testSave() throws Exception {
		
		Owner owner = Owner.builder().id(OWNER_ID).surname(LAST_NAME).build();
		when(repository.save(any())).thenReturn(owner);
		
		Owner saved = service.save(owner);
		
		assertNotNull(saved);
		verify(repository).save(any());
		
	}

	@Test
	public void testDelete() throws Exception {
		
		Owner owner = Owner.builder().id(OWNER_ID).surname(LAST_NAME).build();
		service.delete(owner);
		verify(repository).delete(owner);
		
	}

	@Test
	public void testDeleteById() throws Exception {
		
		service.deleteById(OWNER_ID);
		verify(repository).deleteById(anyLong());
		
	}

}
