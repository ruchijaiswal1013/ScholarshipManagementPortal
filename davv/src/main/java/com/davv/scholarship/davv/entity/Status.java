package com.davv.scholarship.davv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status implements Serializable {
	
	// Defining entity for Status class
	@Id
	@Column(name="user_name")
	private String userName;
	
	@Column(name="status")
	private String status;

	//-------------------------------------------------------------------------------------
	// Getters and Setters for Status class
	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//-------------------------------------------------------------------------------------
	// Constructor for Status Class
	public Status(String username, String status) {
		super();
		this.userName = username;
		this.status = status;
	}
	public Status() {
		super();
		
	}
	
	
}
