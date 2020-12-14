package com.wf.training.bootapprestfulcrud.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.InvestorDto;
import com.wf.training.bootapprestfulcrud.dto.LoginDto;
import com.wf.training.bootapprestfulcrud.entity.Company;
import com.wf.training.bootapprestfulcrud.entity.Investor;
import com.wf.training.bootapprestfulcrud.entity.RecentlyViewedCompanies;
import com.wf.training.bootapprestfulcrud.repository.CompanyRepository;
import com.wf.training.bootapprestfulcrud.repository.InvestorRepository;
import com.wf.training.bootapprestfulcrud.repository.RecentViewCompRepository;
import com.wf.training.bootapprestfulcrud.service.InvestorService;
@Service
public class InvestorServiceImp implements InvestorService {
	
	@Autowired
	private InvestorRepository invRepository;
	
	@Autowired
	private RecentViewCompRepository recentViewRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
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
	
	private RecentlyViewedCompanies convertRecentViewDtoToEntity(LoginDto investorLoginDto, CompanyDto companyDto) {
		RecentlyViewedCompanies recentlyViewedCompanies = new RecentlyViewedCompanies();
		
		recentlyViewedCompanies.setCompanyTitle(companyDto.getCompanyTitle());
		LocalDate date = LocalDate.now();
		recentlyViewedCompanies.setDateTime(date.toString());
		recentlyViewedCompanies.setLoginKey(investorLoginDto.getLoginKey());
		
		return recentlyViewedCompanies;
	}
	
	private CompanyDto convertRecentViewEntityToCompanyDto(RecentlyViewedCompanies recentlyViewedCompanies) {
		
		CompanyServiceImp csi = new CompanyServiceImp();
				
		Company company = this.companyRepository.findBycompanyTitle(recentlyViewedCompanies.getCompanyTitle()).orElse(null);
		
		CompanyDto companyDto = csi.convertCompanyEntityToOutputDto(company);
		
		return companyDto;
		
	}

	@Override
	public List<InvestorDto> fetchAllInvestors() {
		return null;
	}

	@Override
	public InvestorDto fetchSingleInvestor(Long id) {
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
		return null;
	}

	@Override
	public InvestorDto deleteInvestor(Long id) {
		return null;
	}
	
	@Override
	public RecentlyViewedCompanies addRecentViewCompany(LoginDto investorLoginDto, CompanyDto companyDto) {
		RecentlyViewedCompanies recentlyViewedCompanies = this.convertRecentViewDtoToEntity(investorLoginDto,companyDto);
		
		RecentlyViewedCompanies existingRecentlyViewed = this.recentViewRepository.findByLoginKeyAndCompanyTitle(recentlyViewedCompanies.getLoginKey(), 
				recentlyViewedCompanies.getCompanyTitle()).orElse(null);
		if (existingRecentlyViewed!=null) {
			return null;
		}
		RecentlyViewedCompanies newRecentlyViewedCompanies = this.recentViewRepository.save(recentlyViewedCompanies);
		
		return newRecentlyViewedCompanies;
	}
	
	@Override
	public List<CompanyDto> getAllRecentViewCompanies(String loginKey) {
		List<RecentlyViewedCompanies> recentViewCompanies = this.recentViewRepository.findAllByLoginKey(loginKey).orElse(null);
		
		List<CompanyDto> allRecentCompanies = recentViewCompanies.stream().map(this::convertRecentViewEntityToCompanyDto)
				.collect(Collectors.toList());
		
		return allRecentCompanies;
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
