package com.wf.training.bootapprestfulcrud.entity;

public class SuperUser {

	private String name;
	private int superUserId;
	private String password;
	public SuperUser(String name, int superUserId, String password) {
		super();
		this.name = name;
		this.superUserId = superUserId;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSuperUserId() {
		return superUserId;
	}
	public void setSuperUserId(int superUserId) {
		this.superUserId = superUserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
