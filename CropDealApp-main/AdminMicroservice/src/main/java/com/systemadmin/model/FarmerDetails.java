package com.systemadmin.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FarmerList")
public class FarmerDetails {
	@Id
	private int id;
	private int farmerId;
	private String userName;
	private String emailId;
	private String password;
	
	
	public FarmerDetails(int id, int farmerId, String userName, String emailId, String password) {
		super();
		this.id = id;
		this.farmerId = farmerId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDealerId() {
		return farmerId;
	}
	public void setDealerId(int dealerId) {
		this.farmerId = dealerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	
}

	