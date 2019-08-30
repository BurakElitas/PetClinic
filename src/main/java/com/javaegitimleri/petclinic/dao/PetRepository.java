package com.javaegitimleri.petclinic.dao;

import java.util.List;

import com.javaegitimleri.petclinic.model.Pet;

public interface PetRepository {
	Pet findById(long id);
	List<Pet> fingByOwnerId(Long ownerId);
	void create(Pet pet);
	Pet update(Pet pet);
	void delete(long id);
	void deleteByOwnerId(long ownerId);
	
}
