package com.javaegitimleri.petclinic.security;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.service.PetClinicService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties ="spring.profiles.active=dev")
public class PetClinicSecurityWithoutAuthTokenTests {

	@Autowired
	private PetClinicService petClinicService;
	
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void testFindOwners() {
		List<Owner> owners=petClinicService.findOwners();
	}
}
