package com.wf.training.bootapprestfulcrud.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commodity {

	private String commodityName;
	private String currency;
	private float price;
	private LocalDateTime dateTime;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commodityId;
	private int boUserId;
	
	public Commodity(String commodityName, String currency, float price, LocalDateTime dateTime, int commodityId,
			int boUserId) {
		super();
		this.commodityName = commodityName;
		this.currency = currency;
		this.price = price;
		this.dateTime = dateTime;
		this.commodityId = commodityId;
		this.boUserId = boUserId;
	}
	
	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public int getBoUserId() {
		return boUserId;
	}
	public void setBoUserId(int boUserId) {
		this.boUserId = boUserId;
	}
	
	
	
}
