package com.javaegitimleri.petclinic.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.model.Owner;


@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

	private Map<Long,Owner> ownerMap=new HashMap<>();
	
	public OwnerRepositoryInMemoryImpl() {
		Owner own1=new Owner();
		own1.setFirstName("Burak");
		own1.setId(1);
		own1.setLastName("Elitas");
		
		Owner own2=new Owner();
		own2.setFirstName("Gülşah");
		own2.setId(2);
		own2.setLastName("Aydın");
		
		Owner own3=new Owner();
		own3.setFirstName("Aybuke");
		own3.setId(3);
		own3.setLastName("Yazıcı");
		
		Owner own4=new Owner();
		own4.setFirstName("Sude");
		own4.setId(4);
		own4.setLastName("Fidan");
		
		ownerMap.put(own1.getId(),own1);
		ownerMap.put(own2.getId(),own2);
		ownerMap.put(own3.getId(),own3);
		ownerMap.put(own4.getId(),own4);
	}
	
	@Override
	public List<Owner> findAll() {
		return new ArrayList<>(ownerMap.values());
	}

	@Override
	public Owner findById(long id) {
		Owner owner=ownerMap.get(id);
		return owner;
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		List<Owner> list=ownerMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void create(Owner owner) {
		owner.setId(new Date().getTime());
		ownerMap.put(owner.getId(), owner);
	}

	@Override
	public Owner update(Owner owner) {
		ownerMap.replace(owner.getId(), owner);
		return owner;
	}

	@Override
	public void delete(long id) {
		ownerMap.remove(id);
	}

}
