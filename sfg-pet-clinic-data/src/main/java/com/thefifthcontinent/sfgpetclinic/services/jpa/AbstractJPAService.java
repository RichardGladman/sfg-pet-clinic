package com.thefifthcontinent.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.thefifthcontinent.sfgpetclinic.model.BaseEntity;
import com.thefifthcontinent.sfgpetclinic.services.CrudService;

public abstract class AbstractJPAService <T extends BaseEntity, R extends CrudRepository<T, Long>> implements CrudService<T> {

	protected final R repository;

	
	public AbstractJPAService(R repository) {
		super();
		this.repository = repository;
	}
	
	
	@Override
	public T findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	@Override
	public Set<T> findAll() {
		Set<T> data = new HashSet<>();
		repository.findAll().forEach(data::add);
		return data;
	}
	

	
	@Override
	public T save(T object) {
		return repository.save(object);
	}

	
	@Override
	public void delete(T object) {
		repository.delete(object);
	}

	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
