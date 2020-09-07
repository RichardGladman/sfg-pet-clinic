package com.thefifthcontinent.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thefifthcontinent.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
