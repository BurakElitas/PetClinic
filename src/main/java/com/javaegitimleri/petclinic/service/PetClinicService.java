package com.javaegitimleri.petclinic.service;

import java.util.List;

import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;

public interface PetClinicService {
	List<Owner> findOwners();
	List<Owner> findOwners(String lastName);
	Owner findOwner(long id) throws OwnerNotFoundException;
	void crateOwner(Owner owner);
	void update(Owner owner);
	void deleteOwner(long id);
	
}
