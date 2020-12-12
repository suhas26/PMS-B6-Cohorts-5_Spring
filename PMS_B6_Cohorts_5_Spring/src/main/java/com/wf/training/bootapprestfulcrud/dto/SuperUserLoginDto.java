package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SuperUserLoginDto {

	@NotBlank(message="Password is Mandatory")
	private String password;
	
	@NotNull(message="Login id is Mandatory")
	private Integer superUserId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSuperUserId() {
		return superUserId;
	}

	public void setSuperUserId(Integer superUserId) {
		this.superUserId = superUserId;
	}

	

}
