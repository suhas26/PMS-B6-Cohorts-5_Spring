package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import com.wf.training.bootapprestfulcrud.dto.AddCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.AddCompanyOutputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyOutputDto;


public interface CompanyService {

	public List<SearchCompanyOutputDto> fetchAllCompanies();
	public SearchCompanyOutputDto fetchSingleCompany(Long id);
	public AddCompanyOutputDto addCompany(AddCompanyInputDto addCompanyInputDto);
	public SearchCompanyOutputDto editCompany(Long id, SearchCompanyInputDto employeeInputDto);
	public SearchCompanyOutputDto deleteCompany(Long id);	
	
}
