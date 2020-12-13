package com.wf.training.bootapprestfulcrud.controller;


//import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wf.training.bootapprestfulcrud.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.bootapprestfulcrud.dto.LoginDto;
import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;
import com.wf.training.bootapprestfulcrud.service.CompanyHistoricalDataService;
import com.wf.training.bootapprestfulcrud.service.CompanyService;
import com.wf.training.bootapprestfulcrud.service.InvestorService;

@Controller
@SessionAttributes("Investor")
@RequestMapping("/user")
public class InvestorContoller {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyHistoricalDataService historicalService;
	@Autowired
	private InvestorService investorService;

	//dashboard for user
	@RequestMapping(value= {"/home","/dashboard","/index"})
//	public String home(Principal principal) {
	public String home(@SessionAttribute("Investor") LoginDto investorLoginDto, Model model) {
		model.addAttribute("Investor", investorLoginDto);
		return "invHomePage";
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
	public String wallet() {
		
		return "Wallet";
	}
	
	@RequestMapping("/searchCompany")
	public String company(@ModelAttribute("company") SearchCompanyDto company) {
		return "invSearchCompany";
	}
	
	@RequestMapping("/searchCompanyName")
	public String searchCompanyName(@Valid @ModelAttribute("company") SearchCompanyDto company, BindingResult result, Model model,
			@SessionAttribute("Investor") LoginDto investorLoginDto) {
		if(result.hasErrors()) {
			return "invSearchCompany";
		}
		CompanyDto searchCompany = this.companyService.fetchSingleCompanyByName(company);
		this.investorService.addRecentViewCompany(investorLoginDto, searchCompany);
		
		model.addAttribute("searchCompany",searchCompany);
		return "invCompanyPage";
	}
	
	@RequestMapping("/historicalPrices/{companyCode}")
	public String companyHistoricalPrice(@PathVariable Long companyCode, Model model) {
		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = 
				this.historicalService.fetchSingleByCompanyId(companyCode);
		
		model.addAttribute("companyHistoricalDataOutputDto", companyHistoricalDataOutputDto);
		return "invCompHistoricalPrices"; 
	}
	
	@RequestMapping("/recentViewCompanies")
	public String recentViewCompanies(@SessionAttribute("Investor") LoginDto investorLoginDto,Model model) {
		
		List<CompanyDto> companyDto = this.investorService.getAllRecentViewCompanies(investorLoginDto.getLoginKey());
		
		model.addAttribute("recentViewCompanies", companyDto);
		
		return "invRecentViewCompanies";
	}







}
