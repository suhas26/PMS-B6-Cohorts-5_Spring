package com.wf.training.bootapprestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// respond back with a view page name
		return "UserHomePage";
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
	
}
