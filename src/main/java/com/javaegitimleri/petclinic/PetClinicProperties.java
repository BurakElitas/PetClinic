package com.javaegitimleri.petclinic;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="petclinic")
public class PetClinicProperties {

	private boolean OwnersWithPets=false;
	
	public boolean isOwnersWithPets() {
		return OwnersWithPets;
	}
	
	public void setOwnersWithPets(boolean ownersWithPets) {
		OwnersWithPets = ownersWithPets;
	}
}
