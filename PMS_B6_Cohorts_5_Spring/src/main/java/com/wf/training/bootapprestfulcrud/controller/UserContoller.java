package com.wf.training.bootapprestfulcrud.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;
import com.wf.training.bootapprestfulcrud.entity.User;

@Controller
@RequestMapping("/user")

public class UserContoller {

	//dashboard for user
	@RequestMapping(value= {"/home","/dashboard","/index"})  // /employee/home
	public String home(Principal principal) {
		// business logic
		
		return "UserHomePage";
	}
	
	// default mapping for parent url
	@RequestMapping()
	public String defaultResponse() {
		// return "user-base";
		return "redirect:/user/home";// ~sendRedirect()
	}
	
	// respond back profile-entry form
	@RequestMapping("/profile-entry") // /employee/profile-entry
	public String profileEntry(Model model) {
//		// share a blank/empty employee object with jsp to map with spring form
//		User user = new User();
//		user.setCountry("IN");
//		String[] languages = new String[] {"Python","C#"};
//		employee.setFavoriteLanguages(languages);
//		model.addAttribute("employee", employee);
		return "employee-profile-entry";
	}
	
	// auto add param value to model container
	// we want to validation : @Valid
//	@PostMapping("/profile-save")
//	public String saveProfile(@Valid @ModelAttribute Employee employee, 
//							  BindingResult result) {
//		if(result.hasErrors()) {
//			// revert back the entry form
//			return "employee-profile-entry";
//		}
//		
//		return "profile-confirm";
//	}
	
	
//	// @RequestMapping(value = { "/profile-save" }, method = RequestMethod.GET)
//	@GetMapping("/profile-save")
//	public String saveProfilePro(String name, String email, String contact) {
//		System.out.println("GET DATA : " + name + " | " + email + " | " + contact);
//		return "profile-confirm";
//	}
	
	@RequestMapping("/wallet")
	public String wallet(Principal principal) {
		// business logic
		
		return "Wallet";
	}
	
	@RequestMapping("/searchCompany")
	public String company(Model model) {
		SearchCompanyDto company = new SearchCompanyDto();
		model.addAttribute("company", company);
		return "SearchCompany";
	}
	
	@PostMapping("/searchCompanyName")
	public String searchCompanyName() {
		// business logic
		
		return "Company";
	}
	
//	@GetMapping("/searchCompanyName")
//	public String searchCompanyNam(String companyName) {
//		// business logic
//		
//		return "Company";
//	}
	












}
