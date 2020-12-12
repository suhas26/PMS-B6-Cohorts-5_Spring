package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BackOfficeLoginDto {

	@NotBlank(message="Password is Mandatory")
	private String password;
	
	@NotNull(message="Login id is Mandatory")
	private Integer loginId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

}
