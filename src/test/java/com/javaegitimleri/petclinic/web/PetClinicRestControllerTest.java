package com.javaegitimleri.petclinic.web;


import java.net.URI;
//import java.awt.List;
import java.util.*;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.javaegitimleri.petclinic.model.Owner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class PetClinicRestControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void setUp() {
		restTemplate=restTemplate.withBasicAuth("user2", "secret");
		
	}
	
	@Test
	public void testCreateOwner() {
		Owner own=new Owner();
		own.setFirstName("Deneme");
		own.setLastName("Elitaş");
		own.setId(25);
		URI location=restTemplate.postForLocation("http://localhost:8080/rest/owner",own);
		
		Owner owner=restTemplate.getForObject(location, Owner.class);
		
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo(own.getFirstName()));
		MatcherAssert.assertThat(owner.getLastName(), Matchers.equalTo(own.getLastName()));
		
	}
	
	@Test
	public void testUpdate() {
//		Owner own=new Owner();
//		own.setFirstName("İlknur");
//		own.setLastName("İrem");
		Owner own=restTemplate.getForObject("http://localhost:8080/rest/owner/1", Owner.class);
		MatcherAssert.assertThat(own.getFirstName(), Matchers.equalTo("İlknur"));

		own.setFirstName("Burak Muhammet");
		restTemplate.put("http://localhost:8080/rest/ownerUpdate/1",own);
		
		Owner owner=restTemplate.getForObject("http://localhost:8080/rest/owner/1", Owner.class);
		
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo(own.getFirstName()));
		MatcherAssert.assertThat(owner.getLastName(), Matchers.equalTo(own.getLastName()));

		
	}
	
	@Test 
	public void testDeleteOwner() {
		//restTemplate.delete("http://localhost:8080/rest/owner/1");
		ResponseEntity<Void> responseEntity= restTemplate.exchange("http://localhost:8080/rest/owner/1", HttpMethod.DELETE,null,Void.class);
		try {
			 restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
			 Assert.fail("Should have not returned owner");
		}catch (HttpClientErrorException e) {
			MatcherAssert.assertThat(e.getStatusCode().value(),Matchers.equalTo(404));
		}
	}
	
	
	@Test
	public void testGetOwnerById() {
		ResponseEntity<Owner> owner=restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
		
		MatcherAssert.assertThat(owner.getStatusCodeValue(),Matchers.equalTo(200));
		MatcherAssert.assertThat(owner.getBody().getFirstName(), Matchers.equalTo("Burak"));
	}
	
	@Test	
	public void testGetOwnersByLastName() {
		ResponseEntity<List> response=restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=Elitas", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		@SuppressWarnings("unchecked")
		List<Map<String,String>> body= response.getBody();
		
		List<String> firstNames=body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Burak"));
		
	}
	
	@Test
	public void testGetAllOwners() {
		ResponseEntity<List> response=restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		@SuppressWarnings("unchecked")
		List<Map<String,String>> body= response.getBody();
		List<String> firstNames=body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("İlknur","Gülşah","Aybuke","Sude"));
	}
}
