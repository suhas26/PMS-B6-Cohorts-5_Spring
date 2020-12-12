package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.AddCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.CompanyOutputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;
import com.wf.training.bootapprestfulcrud.entity.Company;
import com.wf.training.bootapprestfulcrud.repository.CompanyRepository;
@Service
public class CompanyServiceImp implements CompanyService {
	
	// inject repository as dependency
	@Autowired
	private CompanyRepository companyRepository;
	
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
	
	private CompanyOutputDto convertCompanyEntityToOutputDto(Company company) {
		CompanyOutputDto companyOutputCompany = new CompanyOutputDto();
		
		companyOutputCompany.setCompanyCode(company.getCompanyCode());
		companyOutputCompany.setCompanyTitle(company.getCompanyTitle());
		companyOutputCompany.setOperation(company.getOperation());
		companyOutputCompany.setShareCount(company.getShareCount());
		companyOutputCompany.setSharePrice(company.getSharePrice());
		companyOutputCompany.setSector(company.getSector());
		companyOutputCompany.setCurrency(company.getCurrency());
		companyOutputCompany.setTurnover(company.getTurnover());
		companyOutputCompany.setDateTimeIPO(company.getDateTimeIPO());
		companyOutputCompany.setStockExchange(company.getStockExchange());
		companyOutputCompany.setIpoPrice(company.getIpoPrice());
		 
		return companyOutputCompany;
	}
	
	private Company convertCompanyOutputToEntity(CompanyOutputDto companyOutputDto) {
		Company company = new Company();
		
		company.setCompanyCode(companyOutputDto.getCompanyCode());
		company.setCompanyCode(companyOutputDto.getCompanyCode());
		company.setCompanyTitle(companyOutputDto.getCompanyTitle());
		company.setOperation(companyOutputDto.getOperation());
		company.setShareCount(companyOutputDto.getShareCount());
		company.setSharePrice(companyOutputDto.getSharePrice());
		company.setSector(companyOutputDto.getSector());
		company.setCurrency(companyOutputDto.getCurrency());
		company.setTurnover(companyOutputDto.getTurnover());
		company.setDateTimeIPO(companyOutputDto.getDateTimeIPO());
		company.setStockExchange(companyOutputDto.getStockExchange());
		company.setIpoPrice(companyOutputDto.getIpoPrice());
		 
		return company;
	}
	
	private Company convertSearchCompanyDtoToEntity(SearchCompanyDto searchCompanyDto) {
		Company company = new Company();
		
		company.setCompanyTitle(searchCompanyDto.getCompanyName());
		
		return company;
	}

	@Override
	public List<CompanyOutputDto> fetchAllCompanies() {
		return null;
	}

	@Override
	public CompanyOutputDto fetchSingleCompany(Long id) {
		// fetch record from DB
		Company company = this.companyRepository.findById(id).orElse(null);
		// convert entity into output dto
		CompanyOutputDto companyOutputDto =  this.convertCompanyEntityToOutputDto(company);
		return companyOutputDto;
	}
	
	@Override
	public CompanyOutputDto fetchSingleCompanyByName(SearchCompanyDto searchCompanyDto) {
		Company company = this.convertSearchCompanyDtoToEntity(searchCompanyDto);
		
		// fetch record from DB
		Company newcompany = this.companyRepository.findBycompanyTitle(company.getCompanyTitle()).orElseThrow(()->new NullPointerException());
		// convert entity into output dto
		CompanyOutputDto companyOutputDto =  this.convertCompanyEntityToOutputDto(newcompany);
		return companyOutputDto;
	}

	@Override
	public CompanyOutputDto addCompany(AddCompanyInputDto addCompanyInputDto) {
		CompanyOutputDto addCompanyOutputDto = new CompanyOutputDto();
		
		Company company =  this.convertInputAddCompanyToEntity(addCompanyInputDto);
		Company newCompany = this.companyRepository.save(company);
		addCompanyOutputDto = this.convertCompanyEntityToOutputDto(newCompany);
		
		return addCompanyOutputDto;
	}

	@Override
	public CompanyOutputDto editCompany(Long id, SearchCompanyInputDto employeeInputDto) {
		return null;
	}
	
	@Override
	public CompanyOutputDto modifyCompany(CompanyOutputDto companyOutputDto) {
		Company company = this.convertCompanyOutputToEntity(companyOutputDto);
		Company modifyCompany = this.companyRepository.save(company);
		
		CompanyOutputDto companyNewOutputDto = this.convertCompanyEntityToOutputDto(modifyCompany);
		
		return companyNewOutputDto;
	}

	@Override
	public CompanyOutputDto deleteCompany(Long id) {
		return null;
	}

}
