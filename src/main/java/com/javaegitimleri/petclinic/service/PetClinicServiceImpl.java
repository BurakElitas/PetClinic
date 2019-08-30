package com.javaegitimleri.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.dao.PetRepository;
import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;

@Service
@Transactional(rollbackFor = Exception.class)
public class PetClinicServiceImpl implements PetClinicService {
	
	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
 	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository){
		this.ownerRepository=ownerRepository;
	}
	
	@Autowired
	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	@Secured(value= {"ROLE_USER","ROLE_EDITOR"}) //bu metoda sadece bu rollerdeki kullanıcılar erişebilir.
	public List<Owner> findOwners() {
	
		return ownerRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public List<Owner> findOwners(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Owner findOwner(long id) throws OwnerNotFoundException {
		
		Owner owner= ownerRepository.findById(id);
		if(owner==null)
			throw new OwnerNotFoundException("Owner bulunamadı.");
		return owner;
	}

	@Override
	public void crateOwner(Owner owner) {
		
		ownerRepository.create(owner);
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("burak.elitas@outlook.com.tr");
		msg.setTo("onurlimon1528@gmail.com");
		msg.setSubject("Selam!");
		msg.setText("Acun abi Alamanyadan geliyom bit baks yapacam.");
		
		javaMailSender.send(msg);
	}

	@Override
	public void update(Owner owner) {
		ownerRepository.update(owner);
	}

	@Override
	public void deleteOwner(long id) {
		petRepository.deleteByOwnerId(id);
		ownerRepository.delete(id);
		
		
	}

}
