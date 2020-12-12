package com.wf.training.bootapprestfulcrud.controller;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;
import com.wf.training.bootapprestfulcrud.exception.EmployeeException;
import com.wf.training.bootapprestfulcrud.service.CompanyHistoricalDataService;
import com.wf.training.bootapprestfulcrud.service.CompanyService;

@Controller
@RequestMapping("/user")
public class UserContoller {
	@Autowired
	private CompanyService service;
	@Autowired
	private CompanyHistoricalDataService historicalService;

	//dashboard for user
	@RequestMapping(value= {"/home","/dashboard","/index"})
	public String home(Principal principal) {
		
		return "UserHomePage";
	}
	
	@RequestMapping()
	public String defaultResponse() {
		// return "user-base";
		return "redirect:/user/home";
	}
	
	@RequestMapping("/profile-entry")
	public String profileEntry(Model model) {
		return "employee-profile-entry";
	}
	
	
	@RequestMapping("/wallet")
	public String wallet(Principal principal) {
		
		return "Wallet";
	}
	
	@RequestMapping("/searchCompany")
	public String company(@ModelAttribute("company") SearchCompanyDto company) {
		return "invSearchCompany";
	}
	
	
	
	@RequestMapping("/searchCompanyName")
	public String searchCompanyName(@Valid @ModelAttribute("company") SearchCompanyDto company, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "invSearchCompany";
		}
		CompanyDto searchCompany = this.service.fetchSingleCompanyByName(company);
		
		model.addAttribute("searchCompany",searchCompany);
		return "invCompanyPage";
	}
	
	@RequestMapping("/historicalPrices")
	public String companyHistoricalPrice(Principal principal,@ModelAttribute("searchCompany") CompanyDto searchCompany, Model model) {
		System.out.println(principal);
		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = 
				this.historicalService.fetchAllCompanies();
		
		model.addAttribute("companyHistoricalDataOutputDto", companyHistoricalDataOutputDto);
		model.addAttribute("searchCompany", searchCompany);
		System.out.println(searchCompany.getCompanyTitle());
		return "company-historicalPrices"; 
	}
	












}
