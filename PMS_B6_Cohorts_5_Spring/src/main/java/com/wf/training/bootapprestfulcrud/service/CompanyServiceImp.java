package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.AddCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.AddCompanyOutputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyOutputDto;
import com.wf.training.bootapprestfulcrud.entity.Company;
import com.wf.training.bootapprestfulcrud.repository.CompanyRepository;
@Service
public class CompanyServiceImp implements CompanyService {
	
	// inject repository as dependency
	@Autowired
	private CompanyRepository repository;
	
	// utility method
	private SearchCompanyOutputDto convertSearchCompanyEntityToOutputDto(Company company) {
		
		SearchCompanyOutputDto companyOutputDto = new SearchCompanyOutputDto();
		companyOutputDto.setCompanyCode(company.getCompanyCode());
		companyOutputDto.setCompanyTitle(company.getCompanyTitle());
		companyOutputDto.setOperation(company.getOperation());
		companyOutputDto.setShareCount(company.getShareCount());
		companyOutputDto.setSharePrice(company.getSharePrice());
		companyOutputDto.setSector(company.getSector());
		companyOutputDto.setCurrency(company.getCurrency());
		companyOutputDto.setTurnover(company.getTurnover());
		companyOutputDto.setDateTimeIPO(company.getDateTimeIPO());
		companyOutputDto.setStockExchange(company.getStockExchange());
		companyOutputDto.setIpoPrice(company.getIpoPrice());
		
		return companyOutputDto;
	}
	
	private Company convertInputAddCompanyToEntity(AddCompanyInputDto addCompanyInputDto) {
		 Company company = new Company();
		 
		 company.setCompanyTitle(addCompanyInputDto.getCompanyTitle());
		 company.setOperation(addCompanyInputDto.getOperation());
		 company.setShareCount(addCompanyInputDto.getShareCount());
		 company.setSharePrice(addCompanyInputDto.getSharePrice());
		 company.setSector(addCompanyInputDto.getSector());
		 company.setCurrency(addCompanyInputDto.getCurrency());
		 company.setTurnover(addCompanyInputDto.getTurnover());
		 company.setDateTimeIPO(addCompanyInputDto.getDateTimeIPO());
		 company.setStockExchange(addCompanyInputDto.getStockExchange());
		 company.setIpoPrice(addCompanyInputDto.getIpoPrice());
		 
		 return company;
	}
	
	private AddCompanyOutputDto convertAddCompanyEntityToOutput(Company company) {
		AddCompanyOutputDto addCompanyOutputCompany = new AddCompanyOutputDto();
		
		addCompanyOutputCompany.setCompanyCode(company.getCompanyCode());
		addCompanyOutputCompany.setCompanyTitle(company.getCompanyTitle());
		addCompanyOutputCompany.setOperation(company.getOperation());
		addCompanyOutputCompany.setShareCount(company.getShareCount());
		addCompanyOutputCompany.setSharePrice(company.getSharePrice());
		addCompanyOutputCompany.setSector(company.getSector());
		addCompanyOutputCompany.setCurrency(company.getCurrency());
		addCompanyOutputCompany.setTurnover(company.getTurnover());
		addCompanyOutputCompany.setDateTimeIPO(company.getDateTimeIPO());
		addCompanyOutputCompany.setStockExchange(company.getStockExchange());
		addCompanyOutputCompany.setIpoPrice(company.getIpoPrice());
		 
		return addCompanyOutputCompany;
	}

	@Override
	public List<SearchCompanyOutputDto> fetchAllCompanies() {
		return null;
	}

	@Override
	public SearchCompanyOutputDto fetchSingleCompany(Long id) {
		// fetch record from DB
		Company company = this.repository.findById(id).orElse(null);
		// convert entity into output dto
		SearchCompanyOutputDto companyOutputDto =  this.convertSearchCompanyEntityToOutputDto(company);
		return companyOutputDto;
	}

	@Override
	public AddCompanyOutputDto addCompany(AddCompanyInputDto addCompanyInputDto) {
		AddCompanyOutputDto addCompanyOutputDto = new AddCompanyOutputDto();
		
		Company company =  this.convertInputAddCompanyToEntity(addCompanyInputDto);
		Company newCompany = this.repository.save(company);
		addCompanyOutputDto = this.convertAddCompanyEntityToOutput(newCompany);
		
		return addCompanyOutputDto;
	}

	@Override
	public SearchCompanyOutputDto editCompany(Long id, SearchCompanyInputDto employeeInputDto) {
		return null;
	}

	@Override
	public SearchCompanyOutputDto deleteCompany(Long id) {
		return null;
	}

}
