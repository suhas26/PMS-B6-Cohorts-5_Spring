package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.NotNull;

public class SearchCompanyDto {
	@NotNull
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
