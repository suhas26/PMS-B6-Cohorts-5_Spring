package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InvestorDto {
	
	private int investorId;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Size(min=10,max=10)
	private Integer mobileNumber;
	@NotBlank
	private String panId;
	@NotBlank
	private String gender;
	@NotBlank
	@Email
	private String emailId;
	@NotBlank
	private String password;
	@NotBlank
	private String loginKey;
	
	public int getInvestorId() {
		return investorId;
	}
	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPanId() {
		return panId;
	}
	public void setPanId(String panId) {
		this.panId = panId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginKey() {
		return loginKey;
	}
	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}
}
