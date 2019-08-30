package com.javaegitimleri.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javaegitimleri.petclinic.service.PetClinicService;

@Controller
public class PetClinicController {
	
	@Autowired
	private PetClinicService petClinicService; 
	
	
	@RequestMapping(value="/login.html")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/owners")
	public ModelAndView getOwners() {
		ModelAndView model=new ModelAndView();
		model.addObject("owners", petClinicService.findOwners());
		model.setViewName("owners");
		return model;
	}
	
	@RequestMapping("/logout")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping("/pcs")
	@ResponseBody
	public String hello() {
		return "Welcome to my word";
	}
	
	

}
