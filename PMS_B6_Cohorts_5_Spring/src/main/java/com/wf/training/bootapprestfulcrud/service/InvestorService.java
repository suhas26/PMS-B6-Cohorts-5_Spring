package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import com.wf.training.bootapprestfulcrud.dto.InvestorDto;

public interface InvestorService {

	public List<InvestorDto> fetchAllInvestors();
	public InvestorDto fetchSingleInvestor(Long id);
	public InvestorDto addInvestor(InvestorDto investorDto);
	public InvestorDto editInvestor(Long id, InvestorDto investorDto);
	public InvestorDto deleteInvestor(Long id);	
	
}
