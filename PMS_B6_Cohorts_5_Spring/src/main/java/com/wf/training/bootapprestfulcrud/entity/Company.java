package com.wf.training.bootapprestfulcrud.entity;

import java.time.LocalDateTime;

public class Company {

	private int companyCode;
	private String companyTitle;
	private String operation;
	private int shareCount; 
	private float sharePrice;
	private String sector;
	private String currency; 
	private long turnover;
	private int boUserId;
	private LocalDateTime dateTimeIPO;
	
	public Company(int companyCode, String companyTitle, String operation, int shareCount, float sharePrice,
			String sector, String currency, long turnover, int boUserId, LocalDateTime dateTimeIPO) {
		super();
		this.companyCode = companyCode;
		this.companyTitle = companyTitle;
		this.operation = operation;
		this.shareCount = shareCount;
		this.sharePrice = sharePrice;
		this.sector = sector;
		this.currency = currency;
		this.turnover = turnover;
		this.boUserId = boUserId;
		this.dateTimeIPO = dateTimeIPO;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyTitle() {
		return companyTitle;
	}
	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}
	public float getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}
	public int getBoUserId() {
		return boUserId;
	}
	public void setBoUserId(int boUserId) {
		this.boUserId = boUserId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getShareCount() {
		return shareCount;
	}
	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getTurnover() {
		return turnover;
	}
	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}
	public LocalDateTime getDateTimeIPO() {
		return dateTimeIPO;
	}
	public void setDateTimeIPO(LocalDateTime dateTimeIPO) {
		this.dateTimeIPO = dateTimeIPO;
	}
	
	
}
