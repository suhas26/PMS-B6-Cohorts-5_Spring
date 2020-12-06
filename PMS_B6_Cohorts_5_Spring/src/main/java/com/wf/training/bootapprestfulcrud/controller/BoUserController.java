package com.wf.training.bootapprestfulcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.dto.AddCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.AddCompanyOutputDto;
import com.wf.training.bootapprestfulcrud.service.CompanyService;

@Controller
@RequestMapping("/bouser")
public class BoUserController {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/home")
	public String returnHome() {
		// add business logic
		
		// respond back with a view page name
		return "BackOfficeUserHomePage";
	}

	@RequestMapping("/validate")
	public String loginValidate() {
		// add business logic
		
		// respond back with a view page name
		return "index";
	}
	
	@RequestMapping("/returnAddCompany")
	public String returnAddCompany(@ModelAttribute("createCompany") AddCompanyInputDto createCompany) {
		// add business logic
		
		
		// respond back with a view page name
		return "CreateCompany";
	}
	
	@PostMapping("/createCompany")
	public String addCompany(@Valid AddCompanyInputDto addCompany,BindingResult result, Model model) {
		System.out.println("Add Company");
		if (result.hasErrors()) {
			return "CreateCompany";
		}
		
		AddCompanyOutputDto addCompanyOutputDto = this.companyService.addCompany(addCompany);
		
		model.addAttribute("AddCompanyOutput", addCompanyOutputDto);
		// respond back with a view page name
		return "CreatedCompany";
	}
}
