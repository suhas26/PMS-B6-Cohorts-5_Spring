package com.wf.training.bootapprestfulcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;
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
	public String returnAddCompany(@ModelAttribute("createCompany") CompanyDto createCompany) {
		// add business logic
		
		
		// respond back with a view page name
		return "CreateCompany";
	}
	
	@PostMapping("/createCompany")
	public String addCompany(@Valid @ModelAttribute("createCompany") CompanyDto createCompany,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "CreateCompany";
		}
		
		CompanyDto addCompanyOutputDto = this.companyService.addCompany(createCompany);
		
		model.addAttribute("CompanyOutput", addCompanyOutputDto);
		// respond back with a view page name
		return "SavedCompany";
	}
	
	@RequestMapping("/selectModifyCompany")
	public String selectModifyCompany(@ModelAttribute("selectCompany") SearchCompanyDto searchCompanyDto) {
		return "SelectModifyCompany";
	}
	
	@RequestMapping("/returnModifyCompany")
	public String returnModifyCompany(@Valid @ModelAttribute("selectCompany") SearchCompanyDto searchCompanyDto, BindingResult result, @ModelAttribute("companyNewOutputDto") CompanyDto companyNewOutputDto, Model model) {
		if (result.hasErrors()) {
			return "SelectModifyCompany";
		}
		CompanyDto companyOutputDto = new CompanyDto();
		
		companyOutputDto = this.companyService.fetchSingleCompanyByName(searchCompanyDto);
		model.addAttribute("searchCompanyDto", companyOutputDto);
		// respond back with a view page name
		return "ModifyCompany";
	}
	
	@RequestMapping("/modifyCompany")
	public String modifyCompany(@Valid @ModelAttribute("companyNewOutputDto") CompanyDto companyNewOutputDto, BindingResult result, Model model) {
		System.out.println("modifyCompany");
		System.out.println(companyNewOutputDto);
		System.out.println("modifyCompany");
		
		if (result.hasErrors()) {
			return "ModifyCompany";
		}
		
		CompanyDto companyOutputDto =this.companyService.modifyCompany(companyNewOutputDto);
		model .addAttribute("CompanyOutput", companyOutputDto);
		System.out.println("modifyCompany1");
		System.out.println(companyOutputDto);
		System.out.println("modifyCompany1");
		
		// respond back with a view page name
		return "SavedCompany";
	}
	
	
}
