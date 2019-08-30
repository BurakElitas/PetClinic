package com.javaegitimleri.petclinic.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javaegitimleri.petclinic.dao.PetRepository;
import com.javaegitimleri.petclinic.model.Pet;

public class PetRepositoryJpaImpl implements PetRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Pet findById(long id) {
		return entityManager.find(Pet.class, id);
	
	}

	@Override
	public List<Pet> fingByOwnerId(Long ownerId) {
		
		return entityManager.createQuery("from Pet where owner.id =:ownerid",Pet.class).setParameter("ownerid", ownerId).getResultList();
	}

	@Override
	public void create(Pet pet) {
		entityManager.persist(pet);
	}

	@Override
	public Pet update(Pet pet) {
		return entityManager.merge(pet);
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Pet.class,id));
	}

	@Override
	public void deleteByOwnerId(long ownerId) {
		entityManager.createQuery("delete from Pet where owner.id=:ownerid").setParameter("ownerid",ownerId).executeUpdate();
	}

}
