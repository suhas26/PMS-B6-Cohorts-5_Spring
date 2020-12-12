package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import com.wf.training.bootapprestfulcrud.dto.AddCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.CompanyOutputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;


public interface CompanyService {

	public List<CompanyOutputDto> fetchAllCompanies();
	public CompanyOutputDto fetchSingleCompany(Long id);
	public CompanyOutputDto addCompany(AddCompanyInputDto addCompanyInputDto);
	public CompanyOutputDto editCompany(Long id, SearchCompanyInputDto employeeInputDto);
	public CompanyOutputDto deleteCompany(Long id);
	public CompanyOutputDto fetchSingleCompanyByName(SearchCompanyDto searchCompanyDto);
	CompanyOutputDto modifyCompany(CompanyOutputDto companyOutputDto);
	
}
