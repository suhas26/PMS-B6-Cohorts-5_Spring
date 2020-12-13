package com.wf.training.bootapprestfulcrud.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.InvestorDto;
import com.wf.training.bootapprestfulcrud.dto.LoginDto;
import com.wf.training.bootapprestfulcrud.dto.SuperUserLoginDto;
import com.wf.training.bootapprestfulcrud.entity.Investor;
import com.wf.training.bootapprestfulcrud.repository.InvestorRepository;
import com.wf.training.bootapprestfulcrud.service.InvestorService;
@Service
public class InvestorServiceImp implements InvestorService {
	
	@Autowired
	private InvestorRepository invRepository;
	
	private Investor convertInvestorDtoToEntity(InvestorDto investorDto) {
		Investor investor = new Investor();
		
		investor.setFirstName(investorDto.getFirstName());
		investor.setLastName(investorDto.getLastName());
		investor.setMobileNumber(investorDto.getMobileNumber());
		investor.setPanId(investorDto.getPanId());
		investor.setGender(investorDto.getGender());
		investor.setEmailId(investorDto.getEmailId());
		investor.setLoginKey(investorDto.getLoginKey());
		investor.setPassword(investorDto.getPassword());
		
		return investor;
	}
	
	private InvestorDto convertInvestorEntityToDto(Investor investor) {
		InvestorDto investorDto = new InvestorDto();
		
		investorDto.setInvestorId(investor.getInvestorId());
		investorDto.setFirstName(investor.getFirstName());
		investorDto.setLastName(investor.getLastName());
		investorDto.setMobileNumber(investor.getMobileNumber());
		investorDto.setPanId(investor.getPanId());
		investorDto.setGender(investor.getGender());
		investorDto.setEmailId(investor.getEmailId());
		investorDto.setLoginKey(investor.getLoginKey());
		investorDto.setPassword(investor.getPassword());
		
		return investorDto;
	}

	@Override
	public List<InvestorDto> fetchAllInvestors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestorDto fetchSingleInvestor(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestorDto addInvestor(InvestorDto investorDto) {
		boolean status = this.validateLoginKeyPanPresent(investorDto);
		if (status == true) {
			return null;
		}
		Investor investor = this.convertInvestorDtoToEntity(investorDto);
		Investor newInvestor = this.invRepository.save(investor);
		InvestorDto outInvestorDto = this.convertInvestorEntityToDto(newInvestor);
		return outInvestorDto;
	}

	@Override
	public InvestorDto editInvestor(Long id, InvestorDto investorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestorDto deleteInvestor(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean validateInvestor(LoginDto investorLoginDto) {
		boolean status = false;
		Investor investor = this.invRepository.findByLoginKey(investorLoginDto.getLoginKey()).orElse(null);
		
		if(investor!=null) {
			if(investor.getPassword().equalsIgnoreCase(investorLoginDto.getPassword())) {
				status = true;
			}
		}
		
		return status;
	}
	
	public boolean validateLoginKeyPanPresent(InvestorDto investorDto) {
		boolean status = false;
		Investor investor = this.invRepository.findByLoginKey(investorDto.getLoginKey()).orElse(null);
		
		if(investor!=null) {
			status = true;
		}
		
		Investor panInvestor = this.invRepository.findByPanId(investorDto.getPanId()).orElse(null);
		
		if(panInvestor!=null) {
			status = true;
		}
		
		return status;
	}

}
