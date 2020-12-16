package com.wf.training.bootapprestfulcrud.dto;

public class ShareTransactionDto {
	
	private Long shareTransactionId;
	private String transactionType;
	private String stockName;
	private double stockPrice;
	private Long walletId;
	private int transactionShareCount;
	private String dateTime;
	private double transactionAmount;
	private double commission;
	private String companyCommodity;
	
	public Long getShareTransactionId() {
		return shareTransactionId;
	}
	public void setShareTransactionId(Long shareTransactionId) {
		this.shareTransactionId = shareTransactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public int getTransactionShareCount() {
		return transactionShareCount;
	}
	public void setTransactionShareCount(int transactionShareCount) {
		this.transactionShareCount = transactionShareCount;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public String getCompanyCommodity() {
		return companyCommodity;
	}
	public void setCompanyCommodity(String companyCommodity) {
		this.companyCommodity = companyCommodity;
	}
	
}
