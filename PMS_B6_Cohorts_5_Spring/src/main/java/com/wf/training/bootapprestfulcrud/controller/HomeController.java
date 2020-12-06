package com.wf.training.bootapprestfulcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.entity.SuperUser;
import com.wf.training.bootapprestfulcrud.service.SuperUserService;
import com.wf.training.bootapprestfulcrud.service.SuperUserServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private SuperUserServiceImpl superUserService;
	
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// respond back with a view page name
		return "BackOfficeUserHomePage";
	}
	
	@RequestMapping("/Userlogin")
	public String userLogin() {
		// add business logic
		
		// respond back with a view page name
		return "login";
	}
	
	@RequestMapping("/BOUserLogin")
	public String backOfficeUserLogin() {
		// add business logic
		
		// respond back with a view page name
		return "BackOfficeUserLogin";
	}
	
	@RequestMapping("/SuperUserLogin")
	public String superUserLogin(Model model) {
		// add business logic
		SuperUser superuser = new SuperUser();
		model.addAttribute("superuser", superuser);
		// respond back with a view page name
		return "SuperUserLogin";
	}
	
	
	@PostMapping("/validate")
	public String loginValidate(@Valid @ModelAttribute("superuser") SuperUser superuser,BindingResult result) {
		System.out.println("Logging in");
		if(result.hasErrors()) {
			System.out.println("Results Error");
			return "SuperUserLogin";
		} else if(superuser.getSuperUserId().equals(1) && superuser.getPassword().equals("abc")) {
			System.out.println("superuser");
			return "SuperUserHomePage";
		}else
			return "SuperUserLogin";
	}
	
	@RequestMapping("/UserRegistration")
	public String userRegistration() {
		// add business logic
		
		// respond back with a view page name
		return "userRegistration";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		// add business logic
		
		// respond back with a view page name
		return "error-page";
	}
	
	@RequestMapping("/custom-login")
	public String customLogin() {
		// add business logic
		
		// respond back with a view page name
		return "custom-login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		// add business logic
		
		// respond back with a view page name
		return "index";
	}
		
}
