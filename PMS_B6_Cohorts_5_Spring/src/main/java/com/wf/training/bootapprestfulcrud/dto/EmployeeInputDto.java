package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmployeeInputDto {

	@NotBlank
	private String name;
	@Email
	private String email;
	
	private String contact;
	
	private Double basicSalary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	
	
}
