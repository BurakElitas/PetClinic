package com.javaegitimleri.petclinic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetClinicConfiguration {
	
	@Autowired
	public PetClinicProperties petclinicproperties;
	
	@Autowired
	public Deneme deneme;

	@PostConstruct
	public void init() {
		System.out.println("değer:"+petclinicproperties.isOwnersWithPets());
		System.out.println("---------------------------");
		System.out.println(deneme.Yas());
	}
}
