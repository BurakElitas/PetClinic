package com.javaegitimleri.petclinic.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.PetRepository;
import com.javaegitimleri.petclinic.model.Pet;

@Repository
public class PetRepositoryJdbcImpl implements PetRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Pet findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> fingByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet update(Pet pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	public void deleteByOwnerId(long ownerId) {
		String sql="delete from T_Pet where Owner_ID=?";
		jdbcTemplate.update(sql,ownerId);
		
		
	}

}
