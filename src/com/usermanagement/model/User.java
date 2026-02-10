package com.usermanagement.model;

public class User {

	private int usedId;
	private String userName;
	private String password;
	private String emailId;

	public User(int userId, String userName, String password, String emailId) {

		this.usedId=userId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
	}
	
	
	public int  getId() {
		return usedId;
	}
	public String  getUsername() {
		return userName;
	}
	public String  getPassword() {
		return password;
	}
	public String  getEmail() {
		return emailId;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}
