package com.javalec.spring_pjt_yeram.model;

public class User {
	
	private String userEmail;
	private String userPassword;
	private String userTel;
	
	
	public User() {
	}
	
	public User(String userEmail, String userPassword, String userTel) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	
	

}
